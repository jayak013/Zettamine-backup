package com.zettamine.java.oops;

public class StaticTest1 {
	int x =27;
	static {
		System.out.println("static block-1");
	}
	static int i = getData();
	public static void main(String[] args) {
		System.out.println("inside main method");

	}
	private static int getData() {
		System.out.println("inside getData()");
		return 101;
	}
	static {
		System.out.println("static block-2");
	}
}
