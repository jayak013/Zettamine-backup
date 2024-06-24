package com.zettamine.java.except;

public class Except7 {

	public static void main(String[] args) {
		try {
			System.out.println("outer try..");
			
			try {
				System.out.println("inner try..");
				throw new ArithmeticException();
			}catch(Exception ex) {
				System.out.println("inner catch");
				//throw new ArithmeticException();
			}finally {
				System.out.println("inner finally");
			}
			//System.out.println("outer try-1....");
			throw new ArithmeticException();
		}catch(ArithmeticException ex) {
			System.out.println("outer catch");
		}finally {
			System.out.println("outer finally");
		}
	}

}
