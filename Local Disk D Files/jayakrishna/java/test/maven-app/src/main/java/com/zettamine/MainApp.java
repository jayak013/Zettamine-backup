package com.zettamine;

import java.util.Scanner;

import com.zettamine.utils.Calculator;

public class MainApp {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Calculator c = new Calculator();
		System.out.println("Enter the two values: ");
		int first = scn.nextInt();
		int second = scn.nextInt();
		System.out.println("Addition: "+c.add(first, second));
		System.out.println("Subtraction: "+c.sub(first, second));
	}
	
}
