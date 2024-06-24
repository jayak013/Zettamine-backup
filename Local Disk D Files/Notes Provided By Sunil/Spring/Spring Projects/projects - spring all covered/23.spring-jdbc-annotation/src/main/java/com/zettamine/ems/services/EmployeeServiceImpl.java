package com.zettamine.ems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.ems.dao.EmployeeDAO;
import com.zettamine.ems.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;		
	
	public void saveEmployee(Employee emp) {
		int n = dao.saveEmployee(emp);
		if(n > 0)
			System.out.println("Employee Saved !!");
		else
			System.err.println("Employee could not be Saved");
	}

	public void updateEmployee(int empno, Employee emp) {
		int n = dao.updateEmployee(empno, emp);
		if(n > 0)
			System.out.println("Employee Udated !!");
		else
			System.out.println("No Matching Employee to update!!");
	}

	public void deleteEmployeeByNo(int eno) {
		int n = dao.deleteEmployeeByNo(eno);
		if(n > 0)
			System.out.println("Employee Deleted !!");
		else
			System.err.println("No Matching Employee to Delete!!");
	}

	public Employee searchEmployeeByNo(int eno) {
		return dao.findEmployeeByNo(eno);
	}

	public void getAllEmployees() {
		List<Employee> employees = dao.findAll();
		for(Employee emp : employees) {
			System.out.println(emp);			
		}
	}
}