package com.mari.shop.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mari.shop.domain.Attach;
import com.mari.shop.service.ProductService;
import com.mari.shop.utils.UploadUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@Log
@RequiredArgsConstructor
public class UploadController {
	
	private final ProductService productService;
	
	@PostMapping("/upload")
	public ResponseEntity<List<Attach>> upload(MultipartFile[] uploadImg) throws Exception{
		String uploadFilename ="";
		List<Attach> attaches = new ArrayList<>();
		
		File uploadPath = new File(UploadUtils.realUploadFolder , getFolder());
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile img : uploadImg) {
			UUID uuid = UUID.randomUUID();
			uploadFilename = uuid.toString() + "_" + img.getOriginalFilename();
			log.info("uploadFilename: " +uploadFilename );
			File saveFile = new File(uploadPath, uploadFilename);
			try {
				img.transferTo(saveFile);
			} catch (Exception e) {
				System.out.println(e);
			} 
			log.info("\n\n uploadPath : " + uploadPath.getAbsolutePath());
			log.info(uploadPath.getAbsolutePath().substring(uploadPath.getAbsolutePath().length()-10,uploadPath.getAbsolutePath().length()));
			
			String savedPath = UploadUtils.uploadFolder + uploadPath.getAbsolutePath()
					.substring(uploadPath.getAbsolutePath().length()-10,
							uploadPath.getAbsolutePath().length());
			
			Attach attach = Attach.builder()
					.imgName(img.getOriginalFilename())
					.uploadPath(savedPath)
					.uuid(uuid.toString()+ "_")
					.build();
			attaches.add(attach);		

		}
		return new ResponseEntity<List<Attach>>(attaches,HttpStatus.OK);
	}
	
	@GetMapping("/display/{productId}")
	public ResponseEntity<List<Attach>> display(@PathVariable Long productId){
		log.info("--------------------------display imgs------------------------------");
		List<Attach> attaches = productService.selectAttach(productId);
		attaches.forEach(a-> log.info("\n Attaches List : " + a.getImgName()+"\n"));
		return new ResponseEntity<List<Attach>>(attaches,HttpStatus.OK);			
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
