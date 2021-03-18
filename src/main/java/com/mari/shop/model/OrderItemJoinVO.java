package com.mari.shop.model;

import com.mari.shop.domain.Category;
import com.mari.shop.domain.OrderItem;
import com.mari.shop.domain.Product;
import com.mari.shop.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderItemJoinVO {
	private OrderItem orderItem;
	private Product product;
	private User user;
	private Category category;
}
