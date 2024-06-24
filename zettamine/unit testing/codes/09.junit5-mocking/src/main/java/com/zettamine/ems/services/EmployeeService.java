package com.zettamine.ems.services;

import java.util.List;

public interface EmployeeService {
	public String getEmployeeNameById(int id);
	
	public List<String> findAllNames();
}
