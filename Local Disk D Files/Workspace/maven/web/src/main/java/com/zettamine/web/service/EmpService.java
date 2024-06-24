package com.zettamine.web.service;

import com.zettamine.web.dao.EmpDAO;
import com.zettamine.web.dto.Employee;

public class EmpService {
	public static EmpDAO dao;
	public EmpService() {
		dao = new EmpDAO();
	}
	public int addEmp(Employee emp) {
		return dao.saveEmp(emp);
	}
}
