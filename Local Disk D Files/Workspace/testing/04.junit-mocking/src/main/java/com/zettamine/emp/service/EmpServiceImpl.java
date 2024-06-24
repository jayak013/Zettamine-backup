package com.zettamine.emp.service;

import com.zettamine.emp.dao.EmpDAO;

public class EmpServiceImpl implements EmpService {
	
	private static EmpDAO dao;

	@Override
	public String findEmpById(Integer id) {
		String eName = dao.findEmpById(id);
		return eName.toUpperCase();
	}

	public static void setDao(EmpDAO dao) {
		EmpServiceImpl.dao = dao;
	}
	
	

}
