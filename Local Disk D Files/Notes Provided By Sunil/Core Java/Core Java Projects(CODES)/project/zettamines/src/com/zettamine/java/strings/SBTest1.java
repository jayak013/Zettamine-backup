package com.zettamine.java.strings;

public class SBTest1 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
	    sb.ensureCapacity(1000);
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
		
		sb.append("Zetta");
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
		sb.trimToSize();
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
		sb.setLength(40);
		System.out.println(sb + " | size="+sb.length() + " | capacity="+sb.capacity());
	}

}
