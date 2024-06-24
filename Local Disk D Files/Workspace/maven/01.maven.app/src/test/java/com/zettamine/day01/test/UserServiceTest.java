package com.zettamine.day01.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zettamine.day01.UserService;

class UserServiceTest {

	@Test
	public void test1() {
		int id = 101;
		UserService u = new UserService();
		String expected = "Jaya Krishna";
		String actual = u.getUserService(id);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int id = 102;
		UserService u = new UserService();
		String expected = null;
		String actual = u.getUserService(id);
		assertEquals(expected, actual);
	}
}
