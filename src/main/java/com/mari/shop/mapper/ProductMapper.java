package com.mari.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mari.shop.domain.Product;
import com.mari.shop.model.Criteria;
import com.mari.shop.model.NewProductModel;
import com.mari.shop.model.PageObject;

@Mapper
public interface ProductMapper {
	
	public List<Product> selectAll();
	
	public List<Product> selectByCategoryId(Long categoryId);

	public Product selectByProductId(Long productId);
	
	public int delete(Long productId);
	
	public int insert(NewProductModel product);
	
	public int update(Product product);
	
	public List<Product> selectWithPage(PageObject pageObject);
	
	public int countAll(Criteria cri);
	
	public List<Product> selectByCategoryIdWithPage(PageObject pageObject);
}
