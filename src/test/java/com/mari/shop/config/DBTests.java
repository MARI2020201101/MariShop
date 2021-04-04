package com.mari.shop.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mari.shop.domain.Attach;
import com.mari.shop.domain.OrderItem;
import com.mari.shop.domain.Product;
import com.mari.shop.mapper.OrderItemMapper;
import com.mari.shop.mapper.ProductMapper;
import com.mari.shop.mapper.UserMapper;
import com.mari.shop.model.Criteria;
import com.mari.shop.model.NewProductModel;
import com.mari.shop.model.OrderItemJoinVO;
import com.mari.shop.model.PageObject;
import com.mari.shop.security.CustomUserDetailsService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:/application.properties")
public class DBTests {
	@Autowired
	private DataSource ds;
	
	//private final Logger log = (Logger) LoggerFactory.getLogger(Logger.class);
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe",
				"toyshop",
				"toyshop"
				)){
			log.info("con: " + con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);

		try (Connection conn = ds.getConnection()) {
			System.out.println("Cooooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);

			assertTrue(0 < getLong(conn, "select count(*) from TBL_USER"));
			System.out.println("get Long Result : " + getLong(conn, "select count(*) from TBL_USER"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getLong(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	
	public void countTest() throws Exception {
		int result = userMapper.count();
		System.out.println("UserMapper count()" + result);
	}
	
	@Autowired
	CustomUserDetailsService service;
	
	
	public void loadUserbyUsernameTest() {
		UserDetails user =service.loadUserByUsername("mari");
		log.info(user.toString());
	}

	
	public void selectAllTest() throws Exception {
		userMapper.selectAll();
		System.out.println("UserMapper selectAll");
	}
	
	public void deleteTest() throws Exception {
		//userMapper.delete(4);
		System.out.println("UserMapper Delete");
	}
	
	
	public void selectAllProductTest() throws Exception {
		productMapper.selectAll();
		System.out.println("==================productMapper selectAll================");
	}
	
	
	public void selectProductByCategoryTest() throws Exception {
		System.out.println("==================productMapper selectByCategory================");
		productMapper.selectByCategoryId(1L);
		
	}
	
	public void selectProductByIdTest() throws Exception {
		System.out.println("==================productMapper selectById================");
		productMapper.selectByProductId(1L);}
	
	
	public void deleteProductTest() throws Exception {
		System.out.println("==================productMapper deleteById================");
		int result= productMapper.delete(2L);
		log.info("=========delete result : "+ result);
		}
	
	public void insertProductTest() throws Exception {
		System.out.println("==================productMapper insert ================");
		NewProductModel npro = NewProductModel.builder()
												.categoryId(2L)
												.detail("detail insert test")
												//.img("img~~")
												.price(13000)
												.productName("test 인형")
												.stock(29)
												.build();
		//int result= productMapper.insert(npro);
		//log.info("=========insert result : "+ result);
		}
	
	public void updateProductTest() throws Exception {
		System.out.println("==================updateMapper insert ================");
		Product pro = Product.builder()
												.categoryId(2L)
												.detail("detail insert test")
												.img("img~~")
												.price(99000)
												.productName("test 인형")
												.stock(29)
												.productId(1L)
												.build();
		int result= productMapper.update(pro);
		log.info("=========insert result : "+ result);
		}
	
	
	public void countProTest() throws Exception{
		Criteria cri = new Criteria();
		productMapper.countAll(cri);
	}
	
	
	public void pagewithCategoryTest() throws Exception{
		log.info("-----------------------------------------");
		Criteria cri = new Criteria(1L);
		int count = productMapper.countAll(cri);
		PageObject pageObject = new PageObject(count,1,cri);
		productMapper.selectByCategoryIdWithPage(pageObject);
	}
	
	
	public void listTest() throws Exception{
		log.info("-----------------------------------------");
		Criteria cri = new Criteria("teddy");
		int count = productMapper.countAll(cri);
		PageObject pageObject = new PageObject(count,5,cri);
		productMapper.list(pageObject);
	}
	@Autowired
	OrderItemMapper orderItemMapper;
	
	
	public void orderItemInsertTest() throws Exception{
		log.info("-------------orderItem Test-----------------");
		OrderItem orderItem = OrderItem.builder().productId(67L).totalPrice(105000).count(1).userId(28L).build();
		orderItemMapper.insert(orderItem);
	}
	
	
	public void orderSelectTest() throws Exception{
		log.info("-------------orderItem mapper select Test-----------------");
		List<OrderItemJoinVO> orderItemMap = orderItemMapper.selectWithProduct(28L);
		log.info("---------------------->>\n\n\n"+orderItemMap.toString());
	}
	
	public void orderItemdeleteTest() throws Exception{
		log.info("-------------orderItem mapper delete Test-----------------");
		int result = orderItemMapper.delete(1L);
		log.info("---------------------->>\n\n\n result : \n"+ result);
	}
	
	public void orderItemUpdateTest() throws Exception{
		log.info("-------------orderItem mapper update Test-----------------");
		OrderItem orderItem = OrderItem.builder().orderItemId(2L).productId(67L).totalPrice(210000).count(2).userId(28L).build();
		int result = orderItemMapper.update(orderItem);
		log.info("---------------------->>\n\n\n result : \n"+ result);
	}
	
	
	@Transactional
	public void selectKeyTest() throws Exception{
		log.info("-------------selectKeyTest-----------------");
		Attach attach = Attach.builder().imgName("attach").uuid("uuid").uploadPath("path").build();
		Attach attach2 = Attach.builder().imgName("attach2").uuid("uuid2").uploadPath("path2").build();
		Product product = Product.builder()
				.categoryId(2L)
				.detail("detail insert test")
				.img("img~~")
				.thumbImg("S_img")
				.price(99000)
				.productName("mapper test")
				.stock(29)
				.attaches(List.of(attach,attach2))
				.build();
		productMapper.insert(product);
		
		for(Attach a : product.getAttaches()) {
			productMapper.insertAttach(a);
		}
	}

	public void selectAttach() throws Exception{
		log.info("-------------selectAttach Test-----------------");
		List<Attach> attaches = productMapper.selectAttach(157L);
		
	}
	@Test
	public void listv2Test() throws Exception{
		log.info("------------------list v2 test-----------------------");
		/*
		 *  1. 일반 리스트 
		 *  2. 검색어o, 카테고리x 
		 *  3. 검색어x, 카테고리o 
		 *  4. 검색어o, 카테고리o
		 */
		
		Criteria cri = new Criteria(1L,"왕");
		int count = productMapper.countAll(cri);
		PageObject pageObject = new PageObject(count,2,cri);
		productMapper.list_v2(pageObject);
	}
	
}
