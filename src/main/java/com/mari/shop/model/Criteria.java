package com.mari.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
	private Long categoryId;
	private String keyword;
	
	public Criteria(Long categoryId) {
		super();
		this.categoryId = categoryId;
	}

	public Criteria(String keyword) {
		super();
		this.keyword = keyword;
	}

	
	
}
