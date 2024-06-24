package com.zettamine.ems.dao;

import java.util.List;

import com.zettamine.ems.dto.Employee;

public interface EmployeeDAO {

	Integer saveEmployee(Employee emp);
	
	Integer updateById(Integer id,Employee emp);
	
	Integer deleteById(Integer id);
	
	Employee findById(Integer id);
	
	List<Employee> findAll();
	
	boolean isExists(Integer id);
	
	void terminateConnections();
}
