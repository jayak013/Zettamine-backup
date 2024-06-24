package com.zettamine.ems.services;

import com.zettamine.ems.dto.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee emp);
	
	public void updateEmployee(int empno, Employee emp);
	
	public void deleteEmployeeByNo(int eno);
	
	public Employee searchEmployeeByNo(int eno);
	
	public void getAllEmployees();
}
