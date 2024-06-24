package com.zettamine.test;

public class Palindrome {
	public boolean isPalindrome(String s) {
		return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
	}
}
