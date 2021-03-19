package com.mari.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mari.shop.domain.OrderItem;
import com.mari.shop.mapper.OrderItemMapper;
import com.mari.shop.model.OrderItemJoinVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService{

	private final OrderItemMapper orderItemMapper;

	@Override
	public int insert(OrderItem orderItem) {
		return orderItemMapper.insert(orderItem);
	}

	@Override
	public int delete(Long orderItemId) {
		return orderItemMapper.delete(orderItemId);
	}

	@Override
	public int update(OrderItem orderItem) {
		return orderItemMapper.update(orderItem);
	}

	@Override
	public List<OrderItemJoinVO> list(Long userId) {
		return orderItemMapper.selectWithProduct(userId);
	}
	

}
