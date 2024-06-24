package com.zettamine.java.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String call = "CALL HIKE_SALARY(?,?,?)";
		CallableStatement cst = con.prepareCall(call);
		cst.setInt(1, 102);
		cst.setInt(2, 10);
		cst.registerOutParameter(3, Types.DECIMAL);
		cst.execute();
		System.out.println("Updated salary: "+cst.getBigDecimal(3));
	}
	
}
