package com.mari.shop.model;

import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile img;
	private int price;
	private String productName;
	private int stock;
	private Long categoryId;
}
