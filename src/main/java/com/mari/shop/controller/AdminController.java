package com.mari.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mari.shop.domain.User;
import com.mari.shop.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/admin/**")
@Log
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	
	@GetMapping("/")
	public String index() {
		return "/admin/index";
	}
	//회원관리 메뉴 
	@GetMapping("/manageUser")
	public String manageUser(Model model) {
		log.info("manageuser-----------------------");
		List<User> userList = adminService.listAll();
		model.addAttribute("userList", userList);
		return "/admin/manageUser";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(Long userId, RedirectAttributes rttr) {
		int result = adminService.deleteUser(userId);
		if(result==1)
			rttr.addFlashAttribute("result","삭제 성공");
		else rttr.addFlashAttribute("result", "삭제 실패");
		return "redirect:/admin/manageUser";
			
	}

}
