package com.zettamine.ums.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.DEFAULT)
//@FixMethodOrder(MethodSorters.JVM)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	private static UserService uServiceObj;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uServiceObj = new UserServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		uServiceObj = null;
	}

	@Test
	public void testFindUserNameById() {
		int id = 101;
		String expected = "Sanjay";
		String actual = uServiceObj.findUserNameById(id);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindUserNameByIdTwo() {
		int id = 100;
		String actual = uServiceObj.findUserNameById(id);
		assertNull(actual);
	}

	@Test
	public void testFindUserNameByIdOne() {
		int id = 1258;
		String actual = uServiceObj.findUserNameById(id);
		assertNotNull(actual);
	}

	@Test(timeout = 2500)
	public void testFindUserNameByIdSix() {
		int id = 1258;
		String actual = uServiceObj.findUserNameById(id);
	}

	@Test
	public void testUnderstandingSame() {
		String s1 = "Zetta";
		String s2 = "Zetta";
		assertSame(s1, s2);
	}

	@Test
	public void testUnderstandingNotSame() {
		String s1 = new String("Zetta");
		String s2 = new String("Zetta");
		// assertSame(s1, s2);
		assertNotSame(s1, s2);
	}

	@Test
	public void testArrayEquals() {
		int[] data1 = { 10, 20, 30, 40, 50 };
		int[] data2 = { 10, 20, 30, 40, 60 };
		System.out.println(data1);
		System.out.println(data2);
		assertArrayEquals(data1, data2);
	}

	@Test
	public void testThrows() {
		int[] data1 = { 10, 20, 30, 40, 50 };
		int[] data2 = { 10, 20, 30, 40, 60 };
		System.out.println(data1);
		System.out.println(data2);
		assertArrayEquals(data1, data2);
	}

}
