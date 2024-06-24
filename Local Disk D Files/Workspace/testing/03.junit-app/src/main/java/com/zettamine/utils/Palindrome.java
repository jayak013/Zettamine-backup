package com.zettamine.utils;

public class Palindrome {
	public boolean isPalindrome(String s) {
		return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
	}
}
