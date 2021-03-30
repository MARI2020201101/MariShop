package com.mari.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;

@RestController
@Log
public class UploadController {
	
	@PostMapping("/upload")
	public void upload(MultipartFile[] uploadImg) {
		
		
		for(MultipartFile img : uploadImg) {
			log.info(img.getOriginalFilename());
			log.info(img.getName());
			log.info(img.getContentType());
			log.info(img.getSize()+"");
		}
		
	}

}
