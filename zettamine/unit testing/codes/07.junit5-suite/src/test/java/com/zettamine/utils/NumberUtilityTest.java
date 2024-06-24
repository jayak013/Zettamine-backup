package com.zettamine.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class NumberUtilityTest {
	@ParameterizedTest	
	@CsvSource(value = {
	       "10,EVEN","11, ODD","12,EVEN","13,ODD"
	       }, delimiter = ',')
	void testCheckEvenOrOdd(String num, String expected) {
		NumberUtility obj = new NumberUtility();
		String actual = obj.checkEvenOrOdd(Integer.parseInt(num));
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void testCheckEvenOrOdd1(String num, String expected) {
		System.out.println(num + " - " + expected);
		NumberUtility obj = new NumberUtility();
		String actual = obj.checkEvenOrOdd(Integer.parseInt(num));
		assertEquals(expected, actual);
	}
}
