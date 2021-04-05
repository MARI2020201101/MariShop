package com.mari.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mari.shop.domain.Order;
import com.mari.shop.domain.OrderItem;
import com.mari.shop.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
	private final OrderMapper orderMapper;

	@Override
	@Transactional
	public int insert(Order order) {
		int result = 0;
		order.setOrderStatus("YET");
		result += orderMapper.insert(order);
		Long orderId = orderMapper.selectMax();
		for(Long oid : order.getOrderItemId()) {
			OrderItem orderItem = new OrderItem(oid,orderId);
			result += orderMapper.updateOrderItem(orderItem);
		}
		return result;
		
	}

}
