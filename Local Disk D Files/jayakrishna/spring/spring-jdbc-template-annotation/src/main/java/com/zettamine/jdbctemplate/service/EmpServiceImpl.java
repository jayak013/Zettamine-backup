package com.zettamine.jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.jdbctemplate.dao.EmpDAO;
import com.zettamine.jdbctemplate.dto.Employee;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDAO;
	
	public EmpServiceImpl(EmpDAO dao) {
		this.empDAO = dao;
	}
	
	@Override
	public int saveEmployee(Employee emp) {
		return empDAO.saveEmployee(emp);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return empDAO.findEmployeeById(id);
	}
	
	public List<Employee> getAllEmployees(){
		return empDAO.findAll();
	}

}
