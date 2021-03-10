package com.mari.shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String loginForm(@RequestParam(required = false) String error,@RequestParam(required = false)String logout, Model model) {
		log.info("error " + error);
		if(error !=null) model.addAttribute("error", " 유저네임과 패스워드를 확인해 주십시요");
		if(logout !=null)model.addAttribute("logout","logout 처리되었습니다.");
		return "login";
	}
	@PostMapping("/login")
	public String login(String username, String password) throws Exception {
		//User user = userService.login(username, password);
		
		CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
		
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
	
	@GetMapping("/accessError")
	public String accessError(Model model, Authentication authentication) {
		log.info(authentication.toString());
		return "/accessError";
	}
	
}
