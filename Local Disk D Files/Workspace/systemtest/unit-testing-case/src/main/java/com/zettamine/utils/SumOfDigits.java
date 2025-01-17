package com.zettamine.utils;

public class SumOfDigits {

	public int getDigitsSum(String[] alphaNums) {
		if (alphaNums == null)
			throw new NullPointerException("String can't be null");
		if (alphaNums.length == 0)
			throw new NoElementsFoundException("String Array can't be empty");
		int sumOfDigits = 0;
		for (String alphaNum : alphaNums) {
			System.out.println("String : " + alphaNum);
			if (alphaNum == null)
				throw new NullPointerException("String can't be null");
			char[] charArray = alphaNum.toCharArray();
			for (char c : charArray) {
				if (c >= '0' && c <= '9') {
					System.out.println("number : " + c);
					sumOfDigits += (c - '0');
				}

			}
		}
		System.out.println(sumOfDigits);
		return sumOfDigits;
	}

}
