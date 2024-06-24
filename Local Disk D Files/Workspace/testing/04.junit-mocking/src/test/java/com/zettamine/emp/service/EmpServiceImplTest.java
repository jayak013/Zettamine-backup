package com.zettamine.emp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.zettamine.emp.dao.EmpDAO;

class EmpServiceImplTest {

	public static EmpServiceImpl service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service = new EmpServiceImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindByEmpById() {
		EmpDAO mockObj = Mockito.mock(EmpDAO.class);
		service.setDao(mockObj);
		
		Mockito.when(mockObj.findEmpById(101)).thenReturn("Jaya Krishna Seethagari");
		Mockito.when(mockObj.findEmpById(102)).thenReturn("Hari Prasad Seethagari");
		
		int id = 101;
		String empName = service.findEmpById(id);
		System.out.println(empName);
		assertNotNull(empName);
	}

}
