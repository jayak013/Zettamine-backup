package com.zettamine.java.day01;

public class InvalidAgeException extends Exception{
	

	public InvalidAgeException() {
		super();
	}

	public InvalidAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidAgeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAgeException(String message) {
		super(message);
	}

	public InvalidAgeException(Throwable cause) {
		super(cause);
	}
	
}
