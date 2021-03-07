package com.mari.shop.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAlreadyFoundException extends Exception {
	private String msg;
	
}
