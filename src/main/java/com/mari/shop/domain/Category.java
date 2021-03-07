package com.mari.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	/*
	 * CATEGORY_ID NOT NULL NUMBER(19) 
	 * CATEGORY_NAME NOT NULL VARCHAR2(255 CHAR)
	 */
	private Long categoryId;
	private String categoryName;

}
