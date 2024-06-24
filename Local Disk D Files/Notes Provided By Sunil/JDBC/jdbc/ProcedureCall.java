package com.zettamine.java.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class ProcedureCall {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		
		CallableStatement cst = con.prepareCall("{call hike_emp_salary(?, ?, ?)}");
		int id = 102;
		cst.setInt(1, id);
		cst.setInt(2, 10);
		cst.registerOutParameter(3, Types.FLOAT);
		
		cst.execute();
		
		System.out.printf("hiked salary of employee with id: %d = %.2f", id, cst.getFloat(3));
		con.close();
	}

}
