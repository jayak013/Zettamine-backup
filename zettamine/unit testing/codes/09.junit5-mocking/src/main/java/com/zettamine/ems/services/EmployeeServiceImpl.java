package com.zettamine.ems.services;

import java.util.List;

import com.zettamine.ems.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	
	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String getEmployeeNameById(int id) {
		String eName = dao.findEmployeeNameById(id);
		String eNameInUpper = eName.toUpperCase();
		return eNameInUpper;
	}

	@Override
	public List<String> findAllNames() {
		List<String> empNames = dao.findEmployeeNames();
		if(empNames.isEmpty())
			return null;
		
		return empNames;
	}

}
