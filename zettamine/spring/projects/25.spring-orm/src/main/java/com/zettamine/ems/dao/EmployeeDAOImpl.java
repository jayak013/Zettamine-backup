package com.zettamine.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zettamine.ems.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private HibernateTemplate hibTemplate;
	
	@Transactional
	public Integer saveEmployee(Employee emp) {
		int n = (Integer)hibTemplate.save(emp);
		return n;
	}
	
	@Transactional
	public void updateEmployee(Employee emp) {
		hibTemplate.update(emp);
	}

	@Transactional
	public void deleteEmployeeById(int eno) {
		Employee emp = hibTemplate.get(Employee.class, eno);
		if(emp != null) {
			hibTemplate.delete(emp);
			System.out.println("employee deleted");
		}else {
			System.out.println("no matching employee to delete");
		}
		
	}

	public Employee findEmployeeByNo(int eno) {
		return hibTemplate.get(Employee.class, eno);
	}

	public List<Employee> findAll() {		
		return hibTemplate.loadAll(Employee.class);
	}

}
