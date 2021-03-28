package com.mari.shop.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mari.shop.domain.Product;
import com.mari.shop.model.Criteria;
import com.mari.shop.model.PageObject;
import com.mari.shop.model.RegisterModel;
import com.mari.shop.security.CustomUserDetails;
import com.mari.shop.security.CustomUserDetailsService;
import com.mari.shop.service.ProductService;
import com.mari.shop.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequiredArgsConstructor
@Log
public class UserController {
	private final UserService userService;
	private final CustomUserDetailsService userDetailsService;
	private final ProductService productService;

	@GetMapping("/")
	public String index(Model model, Criteria cri, @RequestParam(defaultValue = "1")int currPage) {
		log.info("-------->>\n\n\n"+ cri);
		int totalCnt = productService.countAll(cri);
		PageObject pageObject = new PageObject(totalCnt, currPage, cri);
		List<Product> productList = productService.list(pageObject);
		model.addAttribute("pageObject",pageObject);
		model.addAttribute("productList",productList);
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
	
	@GetMapping("/user/items")
	public String items() {
		return "/user/items";
		
	}
}
