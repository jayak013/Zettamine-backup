package com.zettamine.java.strings;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a string to check for palindrome: ");
		String str = sc.nextLine();
		String strRev = new StringBuffer(str).reverse().toString();
		boolean isPalindrome = str.contentEquals(strRev);
		System.out.printf("\"%s\" is %s",str, ((isPalindrome)?"Palindrome":" Not Palindrome"));
	}

}
