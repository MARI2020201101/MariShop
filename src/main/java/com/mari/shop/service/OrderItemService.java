package com.mari.shop.service;

import java.util.List;

import com.mari.shop.domain.OrderItem;
import com.mari.shop.model.OrderItemJoinVO;

public interface OrderItemService {
	
	public int insert(OrderItem orderItem);
	public int delete(Long orderItemId);
	public int update(OrderItem orderItem);
	public List<OrderItemJoinVO> list(Long userId);
}
