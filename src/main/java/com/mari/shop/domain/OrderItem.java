package com.mari.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	/*
	 * ORDER_ITEM_ID NOT NULL NUMBER(19) 
	 * COUNT NOT NULL NUMBER(10) 
	 * TOTAL_PRICE NOT NULL NUMBER(10) 
	 * PRODUCT_ID NUMBER(19)
	 */
	private Long orderId;
	private int count; //주문 아이템 수량
	private int totalPrice;
	private Long productId;
}
