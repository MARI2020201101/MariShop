package com.mari.shop.service;

import java.util.List;

import com.mari.shop.domain.Attach;
import com.mari.shop.domain.Product;
import com.mari.shop.model.Criteria;
import com.mari.shop.model.PageObject;


public interface ProductService {
	
	public List<Product> selectAll();
	
	public List<Product> selectByCategoryId(Long categoryId);
	
	public Product selectByProductId(Long productId);
	
	public int delete(Long productId);
	
	public int update(Product product);
	
	public int insert (Product product)throws Exception;
	
	public List<Product> selectWithPage(PageObject pageObject);
	
	public int countAll();
	
	public int countAll(Criteria cri);

	public List<Product> selectByCategoryIdWithPage(PageObject pageObject);
	
	public List<Product> list(PageObject pageObject);
	
	public List<Attach> selectAttach(Long productId);
}
