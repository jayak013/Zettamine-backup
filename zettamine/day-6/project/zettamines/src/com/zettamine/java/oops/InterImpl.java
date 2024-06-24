package com.zettamine.java.oops;

public class InterImpl implements Inter1 {
	static int n = 15;
	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String[] args) {
		InterImpl obj = new InterImpl();
		System.out.println(obj.n);
	}
}
