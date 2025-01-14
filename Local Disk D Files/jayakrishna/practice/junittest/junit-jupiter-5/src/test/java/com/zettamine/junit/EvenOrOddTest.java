package com.zettamine.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class EvenOrOddTest {
	


	@Order(2)
	@ParameterizedTest
//	@ValueSource(ints = {2,4,6,8,10})
	@CsvSource(value = {"10,even"})
	void testEvenOrOdd2(Integer num) {
		EvenOrOdd evenOrOdd = new EvenOrOdd();
		String actual = evenOrOdd.evenOrOdd(num);
		String expected = "even";
		assertEquals(expected, actual);
	}
	
	@Test
	@Order(1)
	void testEvenOrOdd1(TestInfo testInfo) {
		System.out.println(testInfo.getTestMethod());
		EvenOrOdd evenOrOdd = new EvenOrOdd();
		String actual = evenOrOdd.evenOrOdd(13);
		String expected = "odd";
		assertEquals(expected, actual);
	}

}
