package com.zettamine.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.zettamine.exceptions.EmptyArrayException;

//@Ignore
public class LargestTest {
	private static Largest larObj;

	// Tear up
	@BeforeClass
	public static void init() {
		larObj = new Largest();
		System.out.println("beforeClass() method invoked\n");
	}

	// Tear Down
	@AfterClass
	public static void destroy() {
		larObj = null;
		System.out.println("afterClass() method invoked");
	}

	@Test
	public void testFindLargest() {
		// Largest larObj = new Largest();
		int[] data = { 12, 25, 4, 63, 11, 5, 9, 8 };
		int expectedResult = 63;
		int actualResult = larObj.findLargest(data);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testFindLargest1() {
		// Largest larObj = new Largest();
		int[] data = { -12, -25, -4, -63, -11, -5, -9, -8 };
		int expectedResult = -4;
		int actualResult = larObj.findLargest(data);
		assertEquals(expectedResult, actualResult);
	}

	// @Test(expected = ArrayIndexOutOfBoundsException.class)
	@Test(expected = EmptyArrayException.class)
	public void testFindLargest2() {
		// Largest larObj = new Largest();
		int[] data = {};
		larObj.findLargest(data);
	}

	@Ignore("--- TESTCASE IMPLEMENTION IS NOT COMPLETED ---")
	@Test(expected = NullPointerException.class)
	public void testFindLargest3() {
		// Largest larObj = new Largest();
		int[] data = null;
		larObj.findLargest(data);
	}

	@Before
	public void beforeEachTest() {
		System.out.println("--- beforeEachMethod() ---");
	}

	@After
	public void afterEachTest() {
		System.out.println("--- afterEachMethod() ---\n");
	}
}
