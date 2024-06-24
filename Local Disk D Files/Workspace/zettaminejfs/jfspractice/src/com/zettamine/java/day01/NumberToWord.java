package com.zettamine.java.day01;

import java.util.Scanner;

public class NumberToWord {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = scn.nextInt();
		System.out.println(number + " number in words is -----> "+numberToWord(number));
		scn.close();
	}
	
	private static String numberToWord(int number) {
		String string = Integer.valueOf(number).toString();
		String word = "";
		for(int i = 0;i<string.length();i++) {
			int digit = string.charAt(i)-'0';
			switch(digit) {
			case 0:
				word+="ZERO ";
				break;
			case 1:
				word+="ONE ";
				break;
			case 2:
				word+="TWO ";
				break;
			case 3:
				word+="THREE ";
				break;
			case 4:
				word+="FOUR ";
				break;
			case 5:
				word+="FIVE ";
				break;
			case 6:
				word+="SIX ";
				break;
			case 7:
				word+="SEVEN ";
				break;
			case 8:
				word+="EIGHT ";
				break;
			case 9:
				word+="NINE ";
			default:
			}
			
		}
		
		return word;
	}
}
