package com.zettamine.boot.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

public class PasswordEncoder {

	public PasswordEncoder() {
		System.out.println("PasswordEncoder :: Constructor");
	}
	
	public String encodePassword(String pwd) {
		Encoder encoder = Base64.getEncoder();
		byte[] encode = encoder.encode(pwd.getBytes());
		return new String(encode);
	}
	
	public void myInit() {
		System.out.println("password encoder initialization");
	}
	
	public void myDestructor() {
		System.out.println("password encoder destructor");
	}
	
}
