package com.CRUD.TravelAgency.TravelAgencyCRUD.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public static ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		
		Map<String, String> response = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			 String fieldName = ((FieldError)error).getField();
			 String message = error.getDefaultMessage();
			 
			 response.put(fieldName, message);
		});
		
		return new  ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}
}
