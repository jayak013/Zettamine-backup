package com.zettamine.java.practice;

public class ExceptionTest {
	public static void main(String[] args) {
		m1();
	}
	public static void m1() throws ArithmeticException {
		//propagation not happening,caller is not handling the exception
	}
}
