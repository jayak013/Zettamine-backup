package com.zettamine.jdbctemplate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zettamine.jdbctemplate.dto.Employee;

public interface EmpService {
	
	int saveEmployee(Employee emp);
	Employee getEmployeeById(Integer id);
	List<Employee> getAllEmployees();
	
}
