package com.zettamine.ums.services;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class MyClassTest {

	@Test
	public void testCheckMethod() {
		MyClass obj = new MyClass();
		/*
		 * assertThrows(NullPointerException.class, new ThrowingRunnable() {
		 * 
		 * @Override public void run() throws Throwable { obj.checkMethod(); } });
		 */

		assertThrows(NullPointerException.class, () -> obj.checkMethod());
		

	}

}
