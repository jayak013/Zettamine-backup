package com.zettamine.day01.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zettamine.day01.OddOrEven;

class OddOrEvenTest {

	@Test
	public void test1() {
		OddOrEven oddOrEven = new OddOrEven();
		int num = 10;
		assertTrue(oddOrEven.isEven(num));
	}
	
	@Test
	public void test2() {
		OddOrEven oddOrEven = new OddOrEven();
		int num = 11;
		assertFalse(oddOrEven.isEven(num));
	}

}
