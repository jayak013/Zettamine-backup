package com.zettamine.ems.dao;

import java.util.List;

import com.zettamine.ems.dto.Employee;

public interface EmployeeDAO {
	public Integer saveEmployee(Employee emp);
	
	public Integer updateEmployee(int empno, Employee emp);
	
	public Integer deleteEmployeeByNo(int eno);
	
	public Employee findEmployeeByNo(int eno);
	
	public List<Employee> findAll();
}
