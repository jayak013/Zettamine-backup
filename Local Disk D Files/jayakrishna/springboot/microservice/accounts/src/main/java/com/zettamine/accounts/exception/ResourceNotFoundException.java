package com.zettamine.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ResourceNotFoundException(String resourceName,String propertyName, Object propertyValue ) {
		super(resourceName+" not found with the "+propertyName+" : "+propertyValue);
	}

}
