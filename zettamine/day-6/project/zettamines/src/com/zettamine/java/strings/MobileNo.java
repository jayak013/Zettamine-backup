package com.zettamine.java.strings;

import java.util.Scanner;

public class MobileNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter an indian mobile no: ");
		String mobileNo = sc.nextLine();
		
		boolean isValid = checkMobileNo(mobileNo);
		System.out.println(isValid);
	}

	private static boolean checkMobileNo(String mobileNo) {
		boolean checkStatus = mobileNo.matches("^[6789][0-9]{9}");
		return checkStatus;
	}
}
