package com.zettamine.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Palindrome {
	String s;
	public boolean isPalindrome(String s) {
		if(s==null) throw new NullPointerException();
		return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
	}
	
	
	public String removeSpaces(String s) {
		return s.replaceAll(" ", "");
	}
	
	public static void main(String[] args) {
		Set t = new TreeSet();
		Set h = new LinkedHashSet();
		
		t.add(new String("ABC"));
		t.add(12);
		
		System.out.println(t);
	}
	

}
