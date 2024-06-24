package com.zettamine.java.wrappers;

public class WrapperTest2 {

	public static void main(String[] args) {
		System.out.println("min value of byte = " + Byte.MIN_VALUE);
		System.out.println("max value of byte = " + Byte.MAX_VALUE);
		
		System.out.println("no of bytes allotted for byte = " + Byte.BYTES + " bytes");
		System.out.println("no of bits allotted for byte = " + Byte.SIZE+" bits");
		
		System.out.println("max value of integer = " + Integer.MAX_VALUE);
		System.out.println("max value of long = " + Long.MAX_VALUE);
		//long data = 2147483647;
		long data = 2147483648L; //The literal 2147483648 of type int is out of 	range
		System.out.println(data);
	}

}
