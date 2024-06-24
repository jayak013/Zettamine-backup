package com.zettamine.ems.service;

import java.util.List;
import java.util.ListIterator;

import com.zettamine.ems.dao.EmployeeDAO;
import com.zettamine.ems.dao.EmployeeDAOImpl;
import com.zettamine.ems.dto.Employee;

public class EmployeeSercviceImpl implements EmployeeService{
	
	private static EmployeeDAO dao = null;

	public EmployeeSercviceImpl() {
		super();
		dao = new EmployeeDAOImpl();
	}

	@Override
	public void saveEmployee(Employee emp) {
		Integer rowsUpdated = dao.saveEmployee(emp);
		if(rowsUpdated>0) {
			System.out.println("Employee record saved.....");
		}else System.out.println("Employee id already exists...");
	}

	@Override
	public void getEmployeeById(Integer id) {
		Employee emp = dao.findById(id);
		if(emp!=null) {
			System.out.printf(" %-3s | %-18s |%-10s\n","EID","EMP NAME","EMP SAL");
			System.out.printf(" %-3d | %-18s |%-10.2f\n",emp.getId(),emp.getName(),emp.getSalary());
		}
		else System.out.println("No Employees found with this id...");
	}

	@Override
	public void updateEmployeeById(Integer id,Employee emp) {
		Integer rowsUpdated = dao.updateById(id,emp);
		if(rowsUpdated>0) {
			System.out.println("Employee record Updated.....");
		}else System.out.println("Employee id does not exist...");
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		Integer rowsDeleted = dao.deleteById(id);
		if(rowsDeleted>0) {
			System.out.println("One Employee is deleted..");
		}else {
			System.out.println("No employees found with that id....");
		}
	}

	@Override
	public void getAllEmployee() {
		List<Employee> emps = dao.findAll();
		if(emps!=null) {
			ListIterator<Employee> it = emps.listIterator();
			System.out.printf(" %-3s | %-18s |%-10s\n","EID","EMP NAME","EMP SAL");
			while(it.hasNext()) {
				Employee emp = it.next();
				System.out.printf(" %-3d | %-18s |%-10.2f\n",emp.getId(),emp.getName(),emp.getSalary());
			}
		}else {
			System.out.println("Table is empty....");
		}
		System.out.println();
	}

	@Override
	public void closeResources() {
		dao.terminateConnections();
	}

	@Override
	public boolean isExist(Integer id) {
		return dao.isExists(id);
	}
}
