package com.zettamine.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class)
class EvenOrOddTest {

	private static EvenOrOdd evenOrOdd;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before the class");
		evenOrOdd = new EvenOrOdd();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After the class");
		evenOrOdd = null;
	}

	@Test
	@DisplayName("EvenOrOdd Single Val")
	@Tag("test")
	@Order(2)
	void testCheckEvenOrOdd() {
		String actual = evenOrOdd.checkEvenOrOdd(12);
		String expected = "EVEN";
		assertEquals(actual, expected);
	}
	
	@ParameterizedTest
	@DisplayName("EvenOrOdd Multiple Val")
	@Tag("test")
	@CsvSource(value = {"10,EVEN","11,ODD","14,EVEN","21,ODD","6,EVEN"})
	@Order(3)
	void testCheckEvenOrOdd1(String input,String expected) {
		String actual = evenOrOdd.checkEvenOrOdd(Integer.parseInt(input));
		assertEquals(actual, expected);
	}
	
	@ParameterizedTest
	@DisplayName("EvenOrOdd Multiple Val Csv File")
	@CsvFileSource(resources = "/evenOrOdd.csv",numLinesToSkip = 1)
	@Tag("dev")
	@Order(4)
	void testCheckEvenOrOdd2(String input,String expected) {
		String actual = evenOrOdd.checkEvenOrOdd(Integer.parseInt(input));
		assertEquals(actual, expected);
	}

	@Test
	@DisplayName("TestInfo")
	@Tag("dev")
	@Order(1)
//	@Timeout(2)
	void testInfoUse(TestInfo testInfo) {
		System.out.println("Class Name: "+testInfo.getTestClass().get().getSimpleName());
		System.out.println("Method Name: "+testInfo.getTestMethod().get().getName());
		System.out.println("Display Name: "+testInfo.getDisplayName());
//		try {
//			Thread.currentThread().sleep(2100);
//		} catch (InterruptedException e) {
//			
//		}
	}
	
	@Test
	@DisplayName("EvenOrOdd Null Val")
	@Tag("test")
	@Order(5)
	void testCheckEvenOrOdd5() {
		assertThrows(NullPointerException.class, () -> evenOrOdd.checkEvenOrOdd(null));
	}
}
