package com.mari.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mari.shop.domain.OrderItem;
import com.mari.shop.model.OrderItemJoinVO;

@Mapper
public interface OrderItemMapper {

	public int insert(OrderItem orderItem);
	
	public List<OrderItemJoinVO> selectWithProduct(Long userId);
	
	public int delete(Long orderItemId);
	
	public int update(OrderItem orderItem);
}
