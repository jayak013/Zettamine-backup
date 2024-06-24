package com.zettamine.java.strings;

import java.util.Arrays;

public class StringSplitMethod {

	public static void main(String[] args) {
		String str = "Java is a Programming Language used for developing platform independent Application.";
		
		String[] words = str.split("\\s");
		System.out.println("no of words = " + words.length);
		
		System.out.println(Arrays.toString(words));
		
		str = "Java, is!a Programming* Language,used for developing* platform@independent Application.";
		//words = str.split("[, !*@]+");
		//words = str.split("[, !*@]+", 0);
		//words = str.split("[, !*@]+", 1);
		words = str.split("[, !*@]+", 3);
		System.out.println();
		
		System.out.println("no of words = " + words.length);
		
		System.out.println(Arrays.toString(words));
	}

}
