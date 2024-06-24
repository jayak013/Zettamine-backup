package com.zettamine.ems.dao;

import java.util.List;

import com.zettamine.ems.entity.Employee;

public interface EmployeeDAO {
	public Integer saveEmployee(Employee emp);
	
	public void updateEmployee(Employee emp);
	
	public void deleteEmployeeById(int eno);
	
	public Employee findEmployeeByNo(int eno);
	
	public List<Employee> findAll();	
}
