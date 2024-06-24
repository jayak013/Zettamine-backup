package com.zettamine.boot.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

public class PasswordEncoder {

	public PasswordEncoder() {
		System.out.println("PasswordEncoder :: Constructor");
	}
	
	public String encodePassword(String pwd) {
		Encoder encoder = Base64.getEncoder();
		byte[] data = pwd.getBytes();
		String encodedData = encoder.encodeToString(data);
		return encodedData;
	}
	
	public void myInit() {
		System.out.println("PasswordEncoder Initialization");
	}
	
	public void myDestructor() {
		System.out.println("PasswordEncoder ddestructor");
	}
}
