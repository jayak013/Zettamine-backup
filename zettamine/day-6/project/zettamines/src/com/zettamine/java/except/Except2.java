package com.zettamine.java.except;

public class Except2 {

	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		method2();		
	}

	private static void method2() {
		method3();
		
	}

	private static void method3() {
		int z = 10 /0;
		System.out.println(z);		
	}

}
