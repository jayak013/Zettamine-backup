package com.zettamine.spring.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.stereotype.Component;
//@Component
public class DataEncryptorUtil {
	
	public DataEncryptorUtil() {
		System.out.println("DataEncryptorUtil :: Constructor");
	}

	public String encodeData(String data) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(data.getBytes());
	}
}
