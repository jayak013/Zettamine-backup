package com.zettamine.java.strings;

import java.util.Scanner;

public class StringMatchMethod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("enter your name: ");
		String name = sc.nextLine();
		boolean nameCheck = name.matches("^[A-Za-z ]+$");
		System.out.println(nameCheck);
		System.out.println("NAME: " + name);
		sc.close();

	}

}
