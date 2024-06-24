package com.zettamine.ems.services;

import com.zettamine.ems.dto.Employee;

public interface EmployeeService {
	void saveEmployee(Employee emp);
	
	void getEmployeeById(Integer id);
	
	void getAllEmployees();
	
	void updateEmployee(Integer id, Employee emp);
	
	void deleteEmployeeById(Integer id);
}
