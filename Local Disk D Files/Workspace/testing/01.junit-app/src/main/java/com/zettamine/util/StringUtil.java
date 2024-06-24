package com.zettamine.util;

public class StringUtil {
	
	public String getMirrorImage(String input) {
		System.out.println("Class: "+getClass().getSimpleName()+" Method Invoked: "+new Throwable().getStackTrace()[0].getMethodName());
		if(input==null) throw new NullPointerException();
		String output = input.concat(" || ").concat(new StringBuilder(input).reverse().toString());
		System.out.println("Method Returns"+output);
		return output;
	}
}
