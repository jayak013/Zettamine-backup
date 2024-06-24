package com.zettamine.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class PalindromeTest {
	
	
	@Test
	public void testIsPalindrome() {
		Palindrome p = new Palindrome();
		boolean actual = p.isPalindrome("MalaYalaM");
		assertEquals(true, actual);
	}
	
	@Test
	public void testIsPalindrome1() {
		Palindrome p = new Palindrome();
		assertThrows(NullPointerException.class, ()->p.isPalindrome(null));
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each Test");
	}


}
