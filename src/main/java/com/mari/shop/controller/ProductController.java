package com.mari.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mari.shop.domain.Product;
import com.mari.shop.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequiredArgsConstructor
@RequestMapping("/product/**")
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/")
	public String listByCategory(Model model, Long categoryId) {
		List<Product> productList = productService.selectByCategoryId(categoryId);
		model.addAttribute("productList", productList);
		return "/product/list";
	}
	
	@GetMapping("/detail")
	public String listByProductId(Model model, Long productId) {
		Product product = productService.selectByProductId(productId);
		model.addAttribute("product",product);
		return "/product/detail";
	}
}
