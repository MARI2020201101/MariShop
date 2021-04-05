package com.mari.shop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mari.shop.domain.Order;
import com.mari.shop.domain.OrderItem;

@Mapper
public interface OrderMapper {
	public int insert(Order order);
	
	public int updateOrderItem(OrderItem orderItem);
	
	public long selectMax();
}
