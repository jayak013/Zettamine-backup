package com.zettamine.ut.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PalindromeCheckTest {
	private String input;
	private boolean expectedResult;

	public PalindromeCheckTest(String input, boolean expectedResult) {
		super();
		this.input = input;
		this.expectedResult = expectedResult;
	}

	@Parameters(name = "{0} --> {1}")
	public static Collection<Object[]> getData(){
		List<Object[]> inputData = Arrays.asList(new Object[][]{{"eye", true},
							{"Zettamine", false},
							{"Madam", true}}) ;
		return inputData;
	}
	
	@Test
	public void testIsPalindrome() {
		PalindromeCheck palObj= new PalindromeCheck();
		boolean actualResult = palObj.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void testIsPalindrome_01() {
		PalindromeCheck palObj= new PalindromeCheck();
		palObj.isPalindrome(null);
	}	
}
