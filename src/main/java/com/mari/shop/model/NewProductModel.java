package com.mari.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class NewProductModel {
	private String detail;
	private String img;
	private int price;
	private String productName;
	private int stock;
	private Long categoryId;
}
