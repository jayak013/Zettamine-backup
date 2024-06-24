package com.zettamine.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PalindromeTest {

	private String input;
	private boolean expectedResult;
	
	
	public PalindromeTest(String input, boolean expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	@Parameters(name = "{index}]: testIsPalindrome({0})")
	public static Collection<Object[]> intializeData(){
		List<Object[]> elements = Arrays.asList(new Object[][] {
			{"eye",true},
			{"Zettamine",false},
			{"madam",true},
			{"Java",false},
			{"India",false},
			{"MalaYalaM",true}
		});
		return elements;
	}

	@Test
	public void testIsPalindrome() {
		Palindrome p = new Palindrome();
		boolean actual = p.isPalindrome(input);
		assertEquals(expectedResult, actual);
	}
}
