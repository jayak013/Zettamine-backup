package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableEmployees {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql = "select * from emp";
		
		ResultSet rs = st.executeQuery(sql);
		/*
		//---- insert a new record with updatable ResultSet ------
		rs.moveToInsertRow();
		rs.updateInt(1, 104);
		rs.updateString(2, "Zetta");
		rs.updateFloat(3, 9999.99f);
		rs.insertRow();
		*/
		
		//---- update an existing record with updatable ResultSet ------
		rs.absolute(2);
		rs.updateString(2, "Shankar Mahadev");
		rs.updateFloat(3, 77777.75f);
		rs.updateRow();
		
		while(rs.next()) {
			int eno = rs.getInt(1);
			String name = rs.getString(2);
			float sal = rs.getFloat("sal");
			
			String emp = String.format("%3d --> %-3d | %-15s | %.2f",rs.getRow(), eno,name, sal);
			System.out.println(emp);
			Thread.sleep(2000);
		}//while
		
		System.out.println("-------------------------------------------------");
		
	}

}
