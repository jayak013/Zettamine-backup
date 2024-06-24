package com.zettamine.java.wrappers;

public class BoxingVsWidening {
	/*
	void method(int n) {
		System.out.println("1 int argument method");
	}*/
	/*
	void method(double n) {
		System.out.println("1 double argument method");
	}

	void method(float n) {
		System.out.println("1 float argument method");
	}
	*/
	void method(long n) {
		System.out.println("1 long argument method");
	}
	
	void method(Integer n) {
		System.out.println("1 Integer argument method");
	}
	public static void main(String[] args) {
		BoxingVsWidening obj = new BoxingVsWidening();
		obj.method(12);
	}

}
