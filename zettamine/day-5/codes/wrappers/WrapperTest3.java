package com.zettamine.java.wrappers;

public class WrapperTest3 {

	public static void main(String[] args) {
		Integer i = Integer.valueOf(26);
		
		byte b = i.byteValue();
		short s = i.shortValue();
		int n = i.intValue();
		long l = i.longValue();
		float f = i.floatValue();
		double d = i.doubleValue();
		System.out.println(b + " | " + s + " | " + n +" | " + l);
		System.out.println(f+ " | " +d);
	}

}
