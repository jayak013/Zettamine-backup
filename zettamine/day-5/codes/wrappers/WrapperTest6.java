package com.zettamine.java.wrappers;

public class WrapperTest6 {

	public static void main(String[] args) {
		System.out.println(Integer.toString(255));
		System.out.println(Integer.toString(255, 2));
		System.out.println("binary of 255 = " + Integer.toBinaryString(255));
		
		System.out.println(Integer.toString(255, 8));
		System.out.println("octa form of 255 = " + Integer.toOctalString(255));
		
		System.out.println(Integer.toString(255, 16));
		System.out.println("hex form of 255 = " + Integer.toHexString(255));
	}

}
