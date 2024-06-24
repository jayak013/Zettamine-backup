package com.zettamine.ems.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.zettamine.ems.dao.EmployeeDAO;

class EmployeeServiceTest {
	private static EmployeeServiceImpl empService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		empService = new EmployeeServiceImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		empService = null;
	}

	@Test
	void testGetEmployeeNameById() {
		//create a mock object for EmployeeDAO
		EmployeeDAO mockObj = Mockito.mock(EmployeeDAO.class);
		//inject mock object to service component
		empService.setDao(mockObj);
		
		//--setting the behaviour for Proxy object 
		Mockito.when(mockObj.findEmployeeNameById(101)).thenReturn("praveen");
		Mockito.when(mockObj.findEmployeeNameById(102)).thenReturn("sanjay");
		
		int id = 102;
		String empName = empService.getEmployeeNameById(id);
		System.out.println(empName);
		assertNotNull(empName);
	}
	
	@Test
	public void testFindAllNames() {
		EmployeeDAO mockObj = Mockito.mock(EmployeeDAO.class);
		empService.setDao(mockObj);
		
		List<String> names = Arrays.asList("Employee-1", "Employee-2");
		Mockito.when(mockObj.findEmployeeNames()).thenReturn(names); //recording
		
		
		List<String> empNames = empService.findAllNames();
		System.out.println(empNames);
		assertNotNull(empNames);
	}
}
