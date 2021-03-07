package com.mari.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mari.shop.model.RegisterModel;
import com.mari.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	@PostMapping("/login")
	public String login(String username, String password) {
		userService.login(username, password);
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
