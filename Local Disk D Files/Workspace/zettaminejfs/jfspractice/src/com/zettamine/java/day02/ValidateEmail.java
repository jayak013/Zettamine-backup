package com.zettamine.java.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
	
	public static void main(String[] args) {
		//Seetha123@gmail.com
		String pattern = "[A-Za-z0-9.]*@[A-Za-z]+[.][A-Za-z]+";
		String validMailorNot = "Seetha1.23@gmail.com98,adhajkd@ag.n1,123@gmail.com";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(validMailorNot);
		while(m.find()) {
			System.out.println(m.group());
		}
	}
	public static boolean validateEmail(String email) {
		return Pattern.matches("[A-Za-z0-9.]*@[A-Za-z]+[.][A-Za-z]+", email);
	}
	
}
