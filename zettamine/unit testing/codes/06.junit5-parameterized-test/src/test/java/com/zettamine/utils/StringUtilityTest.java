package com.zettamine.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	//@Test
	@ParameterizedTest
	@ValueSource(strings = {"eye", "java","malayalam", "racecar", "Radar", "liril", "madam"})
	void testIsPalindrome(String str) {
		System.out.println(str);
		boolean actualResult = strObj.isPalindrome(str);
		//assumeTrue(actualResult);
		assertTrue(actualResult);
	}

}
