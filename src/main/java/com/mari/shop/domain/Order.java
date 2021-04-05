package com.mari.shop.domain;

import java.util.List;

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
	 * ORDER_ITEM_ID NUMBER(19,0)
	 */    
	private Long orderId;
	private String orderDate;
	private String orderStatus; //comp, yet
	private int totalOrderPrice;
	private Long userId;
	private List<Long> orderItemId;
	
	
	public Order(int totalOrderPrice, Long userId) {
		super();
		this.totalOrderPrice = totalOrderPrice;
		this.userId = userId;
	}


	public Order(String orderStatus, int totalOrderPrice, Long userId) {
		super();
		this.orderStatus = orderStatus;
		this.totalOrderPrice = totalOrderPrice;
		this.userId = userId;
	}


	public Order(int totalOrderPrice, Long userId, List<Long> orderItemId) {
		super();
		this.totalOrderPrice = totalOrderPrice;
		this.userId = userId;
		this.orderItemId = orderItemId;
	}
}
