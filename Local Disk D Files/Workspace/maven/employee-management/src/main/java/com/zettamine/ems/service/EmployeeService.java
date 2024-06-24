package com.zettamine.ems.service;

import com.zettamine.ems.dto.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee emp);
	
	void getEmployeeById(Integer id);
	
	void updateEmployeeById(Integer id,Employee emp);
	
	void deleteEmployeeById(Integer id);
	
	void getAllEmployee();
	
	boolean isExist(Integer id);
	
	void closeResources();
}
