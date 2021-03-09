package com.mari.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mari.shop.model.RegisterModel;
import com.mari.shop.security.CustomUserDetails;
import com.mari.shop.security.CustomUserDetailsService;
import com.mari.shop.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequiredArgsConstructor
@Log
public class UserController {
	private final UserService userService;
	private final CustomUserDetailsService userDetailsService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String loginForm() {
		log.info("=============================loginpage======================");
		return "login";
	}
	@PostMapping("/login")
	public String login(String username, String password, Model model,String error) throws Exception {
		//User user = userService.login(username, password);
		CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
		if(error !=null) model.addAttribute("error", " 유저네임과 패스워드를 확인해 주십시요");
		return "redirect:/";
	}
	@GetMapping("/register")
	public String registerForm() {
		
		return "register";
	}
	@PostMapping("/register")
	public String register(RegisterModel registerModel) {
		userService.register(registerModel);
		return "redirect:/";
	}
}
