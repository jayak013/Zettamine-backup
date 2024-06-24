package com.zettamine.ut.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName(value = "TESTING PALINDROME STRING")
//@Disabled
//@TestMethodOrder(OrderAnnotation.class)
@TestMethodOrder(Alphanumeric.class)
class PalindromeCheckTest {
	private static PalindromeCheck palObj;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		palObj = new PalindromeCheck();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		palObj = null;
	}

	@Test
	@DisplayName("Postive Test case - eye")
	@Tag("dev")
	void testIsPalindrome() {
		String input = "eye";
		boolean isPal = palObj.isPalindrome(input);
		assertTrue(isPal);
	}

	@Test
	@Order(value = 2)
	@Tag("qa")
	void testIsPalindrome1() {
		String input = "java";
		boolean isPal = palObj.isPalindrome(input);
		assertFalse(isPal);
	}
	
	@Test
	@Tag("dev")
	//@Disabled
	@Order(1)
	void testIsPalindrome2() {
		String input = null;
		
		assertThrows(NullPointerException.class, ()->palObj.isPalindrome(input));
	}
	
	@Test
	@DisplayName("TEST")
	@Tag("dev")
	//@RepeatedTest(value = 3)
	//@RepeatedTest(value = 3, name = "{displayName} - repetition {currentRepetition} / {totalRepetitions}")
	void testInfomations(TestInfo info) {
		System.out.println("Test Case Name = "+ info.getTestClass().get().getName());
		 System.out.println("Test Method Name = "+ info.getTestMethod().get().getName()+"()");
		 System.out.println("Display Name : "+ info.getDisplayName());
	}
	
	@Test
	public void testFailMethod() {
		//fail("testing fail");
		assertTrue(true);
	}
}
