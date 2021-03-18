package com.mari.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	/*
	 * 
	USER_ID	NUMBER(19,0)
	ADDRESS1	VARCHAR2(255 CHAR)
	ADDRESS2	VARCHAR2(255 CHAR)
	EMAIL		VARCHAR2(255 CHAR)
	PASSWORD	VARCHAR2(255 CHAR)
	PHONE		VARCHAR2(255 CHAR)
	ROLE		VARCHAR2(255 CHAR)
	USERNAME	VARCHAR2(255 CHAR)
	 */
	
	private Long userId;
	private String username;
	private String password;
	private String email;
	private String address1;
	private String address2;
	private String phone;
	private String role;

}
