package com.mari.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	/*
	 * ORDER_ID NOT NULL NUMBER(19) 
	 * ORDER_DATE TIMESTAMP(6) 
	 * ORDER_STATUS VARCHAR2(255 CHAR) 
	 * TOTAL_PRICE NOT NULL NUMBER(10) 
	 * USER_ID NUMBER(19)
	 */    
	private Long orderId;
	private String orderDate;
	private String orderStatus; //comp, yet
	private int totalPrice;
	private Long userId;
}
