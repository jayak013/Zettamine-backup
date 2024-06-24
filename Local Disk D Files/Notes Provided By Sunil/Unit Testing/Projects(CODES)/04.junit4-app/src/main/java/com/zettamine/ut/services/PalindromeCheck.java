package com.zettamine.ut.services;

public class PalindromeCheck {
	public boolean isPalindrome(String input) {
		//input = input.toLowerCase();
		String reverseStr = new StringBuilder(input).reverse().toString();
		if(input.equalsIgnoreCase(reverseStr))
			return true;
		return false;
	}
}
