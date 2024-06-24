package com.zettamine.java.wrappers;

public class WrapperTest5 {

	public static void main(String[] args) {
		int n1 = 25;
		Integer n2 = n1; //boxing
		int n3 = n2;  //un-boxing
		System.out.println(n1 + " | " + n2 + " | " + n3);
		
		Integer x1 = Integer.valueOf(23);
		Integer x2 = Integer.valueOf(24);
		Integer x3 = x1 + x2; //un-boxing, addition, boxing
		System.out.println(x3);
	}

}
