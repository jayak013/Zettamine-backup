package com.zettamine.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.zettamine.accounts.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> customerAlreadyExistsExceptionHandler(CustomerAlreadyExistsException ex, WebRequest webRequest) {
		ErrorResponseDto responseDto = new ErrorResponseDto();
		
		String apiPath = webRequest.getDescription(false);
		apiPath = apiPath.substring(4, apiPath.length());
		
		responseDto.setApiPath(apiPath);
		responseDto.setErrorCode(HttpStatus.BAD_REQUEST);
		responseDto.setErrorMessage(ex.getMessage());
		responseDto.setErrorTime(LocalDateTime.now());
		
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest webRequest) {
		ErrorResponseDto responseDto = new ErrorResponseDto();
		
		String apiPath = webRequest.getDescription(false);
		apiPath = apiPath.substring(4, apiPath.length());
		
		responseDto.setApiPath(apiPath);
		responseDto.setErrorCode(HttpStatus.BAD_REQUEST);
		responseDto.setErrorMessage(ex.getMessage());
		responseDto.setErrorTime(LocalDateTime.now());
		
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
}
