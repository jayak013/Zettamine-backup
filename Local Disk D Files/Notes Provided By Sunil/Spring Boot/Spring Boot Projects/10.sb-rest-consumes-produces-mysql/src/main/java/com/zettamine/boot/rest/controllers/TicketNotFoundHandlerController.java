package com.zettamine.boot.rest.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zettamine.boot.rest.exceptions.TicketNotFoundException;
import com.zettamine.boot.rest.models.ApiError;

@RestControllerAdvice
public class TicketNotFoundHandlerController {
	/*
	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<String> handleTicketNotFoundException(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	*/
	
	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<ApiError> handleTicketNotFoundException(Exception ex){
		ApiError error = new ApiError();
		
		error.setErroMessage(ex.getMessage());
		error.setErrorDate(LocalDateTime.now().toString());
		error.setErrorType(ex.getClass().getName());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}	
}
