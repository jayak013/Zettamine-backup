package com.zettamine.ems.services;

import java.util.List;

import com.zettamine.ems.dao.EmployeeDAO;
import com.zettamine.ems.dao.EmployeeDAOImpl;
import com.zettamine.ems.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeDAO dao;
	
	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
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
			System.out.println("$$$--- No Matching Employee Found ----$$$");
	}

	@Override
	public void getAllEmployees() {
		List<Employee> employees = dao.findAll();
		for(Employee emp : employees) {
			System.out.println(emp);
		}
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
