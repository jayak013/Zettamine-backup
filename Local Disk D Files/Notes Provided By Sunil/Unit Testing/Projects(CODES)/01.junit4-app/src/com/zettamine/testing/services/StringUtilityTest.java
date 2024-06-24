package com.zettamine.testing.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//public class StringUtilityTest extends TestCase { //-JUnit 3
public class StringUtilityTest {
	/*
	 * Postive Test Case - input - ZETTA - output - ZETTA || ATTEZ
	 */
	@Test
	public void testGetMirrorImage() {
		StringUtility strUtil = new StringUtility();
		String input = "ZETTA";
		String expected = "ZETTA || ATTEZ";
		String actual = strUtil.getMirrorImage(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetMirrorImage_01() {
		StringUtility strUtil = new StringUtility();
		String input = null;
		try {
			String actual = strUtil.getMirrorImage(input);
		} catch (NullPointerException ex) {
		}
	}

	@Test(expected = RuntimeException.class)
	public void testGetMirrorImage_02() {
		StringUtility strUtil = new StringUtility();
		String input = "";
		String actual = strUtil.getMirrorImage(input);
	}
}
