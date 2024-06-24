package com.zettamine.jdbctemplate.dao;

import java.util.List;

import com.zettamine.jdbctemplate.dto.Employee;

public interface EmpDAO {
	
	int saveEmployee(Employee emp);
	
	Employee findEmployeeById(Integer id);
	
	List<Employee> findAll();
	
}
