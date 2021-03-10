package com.mari.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mari.shop.domain.Product;

@Mapper
public interface ProductMapper {
	
	public List<Product> selectAll();

}
