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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mari.shop.domain.OrderItem;
import com.mari.shop.model.OrderItemJoinVO;
import com.mari.shop.service.OrderItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/items/**")
@Log
@RequiredArgsConstructor
public class OrderItemController {
	private final OrderItemService orderItemService;
	
	@PostMapping("/new")
	public ResponseEntity<String> insert(@RequestBody OrderItem orderItem) {
		
		int result = orderItemService.insert(orderItem);
		return result >0? 
				new ResponseEntity<String>("success", HttpStatus.OK) 
				: new ResponseEntity<String>("fail" ,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<OrderItemJoinVO>> list(@PathVariable("userId") Long userId) {
		 List<OrderItemJoinVO> orderItems = orderItemService.list(userId);
		 return new ResponseEntity<List<OrderItemJoinVO>>(orderItems, HttpStatus.OK);
	}
	@DeleteMapping("/{orderItemId}")
	public ResponseEntity<String> delete(@PathVariable Long orderItemId) {
		int result = orderItemService.delete(orderItemId);
		return result >0? 
				new ResponseEntity<String>("success", HttpStatus.OK) 
				: new ResponseEntity<String>("fail" ,HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/{orderItemId}")
	public ResponseEntity<String> update(@PathVariable Long orderItemId, @RequestBody OrderItem orderItem) {
		int result = orderItemService.update(orderItem);
		return result >0? 
				new ResponseEntity<String>("success", HttpStatus.OK) 
				: new ResponseEntity<String>("fail" ,HttpStatus.BAD_REQUEST);
	}

}
