package com.mari.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	/*
	 * PRODUCT_ID NOT NULL NUMBER(19) 
	 * DETAIL VARCHAR2(255 CHAR) 
	 * IMG VARCHAR2(255
	 * CHAR) 
	 * PRICE NOT NULL NUMBER(10) 
	 * PRODUCT_NAME NOT NULL VARCHAR2(255 CHAR)
	 * STOCK NOT NULL NUMBER(10) 
	 * CATEGORY_ID NUMBER(19)
	 */
	
	private Long productId;
	private String detail;
	private String img;
	private int price;
	private String productName;
	private int stock;
	private Long categoryId;
	private String thumbImg;
	
	
	
	public Product(String detail, String img, int price, String productName, int stock, Long categoryId) {
		super();
		this.detail = detail;
		this.img = img;
		this.price = price;
		this.productName = productName;
		this.stock = stock;
		this.categoryId = categoryId;
	}



	public Product(String detail, String img, int price, String productName, int stock, Long categoryId,
			String thumbImg) {
		super();
		this.detail = detail;
		this.img = img;
		this.price = price;
		this.productName = productName;
		this.stock = stock;
		this.categoryId = categoryId;
		this.thumbImg = thumbImg;
	}

}
