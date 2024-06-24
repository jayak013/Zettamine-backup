package com.zettamine.java.strings;

public class StringCreations {

	public static void main(String[] args) {
		String s1 = "Zetta";
		String s2 = "Zetta";
		System.out.println(s1 == s2);
		
		String s3 = new String("Java");
		String s4 = new String("Java");
		System.out.println(s3 == s4);
		
		//s1.concat("mine");
		s1 = s1.concat("mine");
		System.out.println(s1);
		
		String str1 = "ABC";
		//String str2 = "ABC";
		String str2 = "ADA";
		int n = str1.compareTo(str2);
		System.out.println(n);
	}

}
