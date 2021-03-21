package com.mari.shop.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandler {
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleGlobalException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); 
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(value=HttpMessageNotReadableException.class )
	public ResponseEntity<String> handleRequestBodyException(HttpMessageNotReadableException e){
		return new ResponseEntity<String>("입력값을 확인해 주십시요..",HttpStatus.BAD_REQUEST);
	}
}
