package com.mari.shop.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mari.shop.domain.Attach;
import com.mari.shop.utils.UploadUtils;

import lombok.extern.java.Log;

@RestController
@Log
public class UploadController {
	
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
			log.info(saveFile.getAbsolutePath());
			Attach attach = Attach.builder()
					.imgName(img.getOriginalFilename())
					.uploadPath(uploadPath.getAbsolutePath())
					.uuid(uuid.toString()+ "_")
					.build();
			attaches.add(attach);		

		}
		return new ResponseEntity<List<Attach>>(attaches,HttpStatus.OK);
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
