package com.mari.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mari.shop.domain.Product;
import com.mari.shop.model.Criteria;
import com.mari.shop.model.PageObject;
import com.mari.shop.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequiredArgsConstructor
//@RequestMapping("/product/**")
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/detail")
	public String listByProductId(Model model, Criteria cri , int totalCnt ,Long productId, @RequestParam(defaultValue = "1")int currPage) {
		System.out.println("======================list detail===================");
		Product product = productService.selectByProductId(productId);
		PageObject pageObject = new PageObject(totalCnt, currPage, cri);
		model.addAttribute("pageObject",pageObject);
		model.addAttribute("product",product);
		return "/product/detail";
	}
}
