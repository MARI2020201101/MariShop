package com.mari.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mari.shop.domain.OrderItem;
import com.mari.shop.model.OrderItemJoinVO;
import com.mari.shop.service.OrderItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController("/items/**")
@Log
@RequiredArgsConstructor
public class OrderItemController {
	private final OrderItemService orderItemService;
	
	@PostMapping("/new")
	public ResponseEntity<String> insert(@RequestBody OrderItem orderitem) {
		
		int result = orderItemService.insert(orderitem);
		if(result ==1 ) {
			return new ResponseEntity<String>("suceess" ,HttpStatus.OK);
			
		}else return new ResponseEntity<String>("fail" ,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<OrderItemJoinVO> list(@PathVariable("userId") Long userId) {
		 List<OrderItemJoinVO> orderItems = orderItemService.list(userId);
		 return new ResponseEntity<>(orderItems, HttpStatus.OK);
	}
	@DeleteMapping("/{orderItemId}")
	public void delete(@PathVariable Long orderItemId) {
		
	}
	@PutMapping("/{orderItem}")
	public void update(@PathVariable OrderItem orderItem) {
		
	}

}
