package com.zettamine.java.day03;

import java.util.regex.Pattern;

public class ValidateMobileNumber {
	
	public static boolean validateMobile(String Mobile) {
		String mobileNoPattern = "[6-9][0-9]{9}";
		return Pattern.matches(mobileNoPattern, Mobile);
	}
}
