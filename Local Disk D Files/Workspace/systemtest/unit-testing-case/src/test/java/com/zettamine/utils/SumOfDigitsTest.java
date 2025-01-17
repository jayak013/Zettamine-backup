package com.zettamine.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SumOfDigitsTest {

	public static SumOfDigits sumOfDigits;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sumOfDigits = new SumOfDigits();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		sumOfDigits = null;
	}

	@Test
	@DisplayName("Arrays Of Strings")
	void testGetDigitsSum() {
		String[] strings = { "1@ws2%", "AB3&%4", "42RT&*32", "80ABrt$U7" };
		int actualValue = sumOfDigits.getDigitsSum(strings);
		int expectedValue = 36;
		assertEquals(expectedValue, actualValue);
	}

	@Test
	@DisplayName("Null Value")
	void testGetDigitsSum1() {
		String[] nullObj = null;
		assertThrows(NullPointerException.class, () -> sumOfDigits.getDigitsSum(nullObj));
	}

	@Test
	@DisplayName("Empty Object")
	void testGetDigitsSum2() {
		String[] emptyObj = {};
		assertThrows(NoElementsFoundException.class, () -> sumOfDigits.getDigitsSum(emptyObj));
	}

	@Test
	@DisplayName("Null String in the Array Of Strings")
	void testGetDigitsSum3() {
		String[] emptyObj = { null, "1@ws2%" };
		assertThrows(NullPointerException.class, () -> sumOfDigits.getDigitsSum(emptyObj));
	}

}
