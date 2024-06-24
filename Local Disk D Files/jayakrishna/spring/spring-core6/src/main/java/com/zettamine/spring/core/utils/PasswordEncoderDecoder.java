package com.zettamine.spring.core.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.stereotype.Component;

//@Component
public class PasswordEncoderDecoder {
	
	public PasswordEncoderDecoder() {
		System.out.println("PasswordEncoderDecoder :: Constructor");
	}
	
	public String getEncoderString() {
		Encoder encoder = Base64.getEncoder();
		String s = "test string";
		byte[] encodedString = encoder.encode(s.getBytes());
		return new String(encodedString);
	}
	
}
