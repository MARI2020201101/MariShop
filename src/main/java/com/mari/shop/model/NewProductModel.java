package com.mari.shop.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mari.shop.domain.Attach;

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
	
	private List<Attach> attaches;

	public NewProductModel(String detail, MultipartFile img, int price, String productName, int stock,
			Long categoryId) {
		super();
		this.detail = detail;
		this.img = img;
		this.price = price;
		this.productName = productName;
		this.stock = stock;
		this.categoryId = categoryId;
	}
}
