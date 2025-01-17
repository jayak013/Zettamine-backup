package com.zettamine.web.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zettamine.web.configs.DBHandler;
import com.zettamine.web.dto.Employee;

public class EmpDAO {
	public static Connection con = null;
	public int saveEmp(Employee emp) {
		int rows = 0;
		try {
			con = DBHandler.establishConnection();
			PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");

			pst.setInt(1, emp.empno);
			pst.setString(2, emp.ename);
			pst.setBigDecimal(3, BigDecimal.valueOf(emp.sal));
			rows = pst.executeUpdate();
			System.out.println("successfully added...");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
