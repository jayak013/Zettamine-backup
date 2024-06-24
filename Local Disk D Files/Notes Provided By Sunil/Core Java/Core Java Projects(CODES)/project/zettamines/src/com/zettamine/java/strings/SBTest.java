package com.zettamine.java.strings;

public class SBTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		//StringBuffer sb = new StringBuffer("zetta");
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
		
		sb.append("Zettamine");
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
		
		sb.insert(0, "******* ");
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
		
		StringBuffer sb1 = new StringBuffer("Java");
		StringBuffer sb2 = new StringBuffer("Java");
		System.out.println(sb1.equals(sb2));
	}
}
