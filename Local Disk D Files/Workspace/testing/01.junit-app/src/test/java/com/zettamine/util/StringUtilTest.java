package com.zettamine.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testGetMirrorImage() {
		StringUtil strUtil = new StringUtil();
		String input = "ZETTA";
		String expectedOutput = input.concat(" || ").concat("ATTEZ");
		String actualOutput = strUtil.getMirrorImage(input);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetMirrorImage1() {
		StringUtil strUtil = new StringUtil();
		String input = null;
		String actualOutput = strUtil.getMirrorImage(input);
	}

}
