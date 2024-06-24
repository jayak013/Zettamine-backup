package com.zettamine.testing;

import com.zettamine.testing.services.Largest;

public class MainApp {

	public static void main(String[] args) {
		int[] data = { 5, 12, 45, 21, 6, 10, 13 };
		int expectedResult = 45;
		Largest larObj = new Largest();
		int actualResult = larObj.findLargest(data);
		if (expectedResult == actualResult)
			System.out.println("Test Passed - " + actualResult);
		else
			System.out.println("Test Failed");
		System.out.println();

		int[] data1 = { -5, 12, -45, 21, -6, 10, -13 };
		expectedResult = 21;
		actualResult = larObj.findLargest(data1);
		if (expectedResult == actualResult)
			System.out.println("Test Passed - " + actualResult);
		else
			System.out.println("Test Failed");
		System.out.println();

		System.out.println();

		int[] data2 = { -5, -12, -45, -21, -6, -10, -13 };
		expectedResult = -5;
		actualResult = larObj.findLargest(data2);
		if (expectedResult == actualResult)
			System.out.println("Test Passed - " + actualResult);
		else
			System.out.println("Test Failed");
		System.out.println();

		System.out.println();

		// int[] data3 = {};
		int[] data3 = null;
		actualResult = larObj.findLargest(data3);
		System.out.println(actualResult);
	}

}
