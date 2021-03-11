package com.mari.shop.service;

import java.util.List;

import com.mari.shop.domain.Product;


public interface ProductService {
	
	public List<Product> selectAll();
	
	public List<Product> selectByCategoryId(Long categoryId);
	
	public Product selectByProductId(Long productId);

}
