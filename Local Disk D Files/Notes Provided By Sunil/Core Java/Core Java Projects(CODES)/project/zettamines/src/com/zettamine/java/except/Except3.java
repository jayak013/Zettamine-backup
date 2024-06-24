package com.zettamine.java.except;

import java.util.Scanner;

public class Except3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("enter first no : ");
			int x = sc.nextInt();

			System.out.print("enter second no: ");
			int y = sc.nextInt();

			int z = x / y;
			System.out.println(x + " / " + y + " = " + z);
		} catch (ArithmeticException ex) {
			System.err.println("catch block");			
			System.exit(0);//return;
		} finally {
			System.out.println("finally block");
			sc.close();
			System.out.println("application designed & developed by");
			System.out.println("team @ zettamine");
		}
		System.out.println("***********************");
	}

}
