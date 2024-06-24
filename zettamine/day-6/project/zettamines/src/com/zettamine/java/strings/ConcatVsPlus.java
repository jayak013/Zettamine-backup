package com.zettamine.java.strings;

public class ConcatVsPlus {

	public static void main(String[] args) {
		String str = new String("Zetta");
		//str = str +"mine";
		//str=str.concat("mine");
		//str = str + null;
		//str=str.concat(null); //java.lang.NullPointerException
		System.out.println(str);
		//String str1 = str.concat("");
		String str1 = str+"";
		System.out.println(str == str1);

	}

}
