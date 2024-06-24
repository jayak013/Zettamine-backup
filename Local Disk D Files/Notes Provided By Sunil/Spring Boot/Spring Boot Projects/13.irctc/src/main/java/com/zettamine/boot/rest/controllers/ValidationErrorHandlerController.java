package com.zettamine.boot.rest.controllers;

import java.util.List;import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandlerController {
	
 @ExceptionHandler(value = MethodArgumentNotValidException.class)	
 public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex){
	 /*
	 List<FieldError> errors = ex.getBindingResult().getFieldErrors();
	 System.out.println(errors);
	 */
	 List<String> errors = ex.getBindingResult().getFieldErrors()
			 					.stream()
			 					.map(except -> except.getField()+": "+except.getDefaultMessage())
			 					.collect(Collectors.toList());
	 return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);	 
 }
}
