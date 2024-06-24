package com.zettamine.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringUtilityTest {
	private static StringUtility strObj;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		strObj = new StringUtility();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		strObj = null;
	}

	@Test
	void testIsPalindrome() {
		String str = "madam";
		boolean result = strObj.isPalindrome(str);
		assertTrue(result);
	}

	@Test
	void testIsPalindrome1() {
		String str = "java";
		boolean result = strObj.isPalindrome(str);
		assertFalse(result);
	}
}
