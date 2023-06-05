package com.spring.security.jwt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionControllerAdvice {
	
	public final ResponseEntity<String> handleCustomException(CustomException exception){
		return new ResponseEntity<> (exception.getMessage(), HttpStatus.BAD_REQUEST);
		
	}

}
