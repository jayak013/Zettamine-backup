package com.zettamine.ems.dao;

import java.util.List;

public interface EmployeeDAO {
	public String findEmployeeNameById(int eid);
	
	List<String> findEmployeeNames();
}
