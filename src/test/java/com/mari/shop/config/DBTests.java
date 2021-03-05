package com.mari.shop.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mari.shop.mapper.UserMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
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
	
	@Test
	public void countTest() throws Exception {
		int result = userMapper.count();
		System.out.println("UserMapper count()" + result);
	}

}
