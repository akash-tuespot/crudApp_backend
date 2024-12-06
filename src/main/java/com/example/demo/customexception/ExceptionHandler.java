package com.example.demo.customexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> productNotFoundHandler(ProductNotFoundException runtimeException){
		Map<String, String> resp = new HashMap<>();
		resp.put("message", runtimeException.getMessage());
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

}
