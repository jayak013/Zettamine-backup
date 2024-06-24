package com.zettamine.ems.services;

import java.util.List;

import com.zettamine.ems.dao.EmployeeDAO;
import com.zettamine.ems.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	
	public EmployeeServiceImpl(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void saveEmployee(Employee emp) {
		Integer rowsInserted = dao.saveEmployee(emp);
		if(rowsInserted > 0)
			System.out.println("###---- Employee Saved ----###");
		else
			System.err.println("###---- Save Operation Failed ... Check the Logs");

	}

	@Override
	public void getEmployeeById(Integer id) {
		Employee emp = dao.findById(id);
		if(emp != null)
			System.out.println(emp);
		else
			System.err.println("no matching employee found");

	}

	@Override
	public void getAllEmployees() {
		List<Employee> emps = dao.findAll();
		emps.stream().forEach(System.out::println);
	}

	@Override
	public void updateEmployee(Integer id, Employee emp) {
		Integer rowsUpdated = dao.updateEmployee(id,emp);
		if(rowsUpdated > 0)
			System.out.println("###---- Employee Updated ----###");
		else
			System.err.println("###---- Update Operation Failed ... Check the Logs");
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		Integer rowsDeleted = dao.deleteById(id);
		if(rowsDeleted > 0)
			System.out.println("###---- Employee Deleted ----###");
		else
			System.err.println("###---- Delete Operation Failed ... Check the Logs");
	}

}
