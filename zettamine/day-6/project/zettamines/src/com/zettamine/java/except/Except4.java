package com.zettamine.java.except;

import java.util.Scanner;

public class Except4 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("enter your name: ");
			String name = sc.nextLine();
			System.out.println("Hello " + name);
		}
	}

}
