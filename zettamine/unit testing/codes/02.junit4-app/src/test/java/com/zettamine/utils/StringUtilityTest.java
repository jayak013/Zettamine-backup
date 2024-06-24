package com.zettamine.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testGetMirrorImage() {
		StringUtility strUtil = new StringUtility();
		String input = "ZETTA";
		String expected = "ZETTA || ATTEZ";
		String actual = strUtil.getMirrorImage(input);
		// assertEquals(expected, actual);
		assertEquals("getting unexpected result", expected, actual);
	}

	@Test
	public void testGetMirrorImage1() {
		StringUtility strUtil = new StringUtility();
		String input = null;
		try {
			strUtil.getMirrorImage(input);
		} catch (NullPointerException ex) {
			System.out.println(ex.toString());
		}
	}

	@Test(expected = RuntimeException.class)
	public void testGetMirrorImage2() {
		StringUtility strUtil = new StringUtility();
		String input = "";
		strUtil.getMirrorImage(input);
	}

	@Test(expected = RuntimeException.class)
	public void testGetMirrorImage3() {
		StringUtility strUtil = new StringUtility();
		String input = "   ";
		strUtil.getMirrorImage(input);
	}
}
