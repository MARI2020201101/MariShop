package com.mari.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mari.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserRestController {
	private final UserService userService;
	
	@PostMapping(value= "/idCheck")
	public ResponseEntity<String> idCheck(@RequestBody String username) throws Exception {
		System.out.println("idcheck-----------------------------");
		System.out.println("idChecked username: " +username);
		if(username==null||username=="") {
			return new ResponseEntity<String>("닉네임을 입력해 주십시요",HttpStatus.BAD_REQUEST);
		}
		userService.idCheck(username);	
		return new ResponseEntity<String>("사용할 수 있는 닉네임입니다!",HttpStatus.OK);
	}

}
