package com.mari.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attach {
	/* 
	UUID	VARCHAR2(255 BYTE)
	IMGNAME	VARCHAR2(255 BYTE)
	UPLOADPATH	VARCHAR2(255 BYTE)
	PRODUCT_ID	NUMBER(19,0)
	 */
	private String uuid;
	private String imgName;
	private String uploadPath;
	private Long productId;
	
	
	public Attach(String uuid, String imgName, String uploadPath) {
		super();
		this.uuid = uuid;
		this.imgName = imgName;
		this.uploadPath = uploadPath;
	}
}
