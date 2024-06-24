package com.zettamine.utils;

public class EmptyStringFoundException extends RuntimeException {

	public EmptyStringFoundException() {
		super();
	}

	public EmptyStringFoundException(String message) {
		super(message);
	}

}
