package com.mari.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/sample/*")
@Log
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		log.info("do all can access everybody");
	}
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("do admin can access only admin");
	}
	@GetMapping("/member")
	public void doMember() {
		log.info("do member can access only member");
	}

	@GetMapping("/login")
	public void getLogin() {
		log.info("get login can access only by login member");
	}
	@PostMapping("/login")
	public void postLogin() {
		log.info("post login can access only by login member");
	}
	

	
}
