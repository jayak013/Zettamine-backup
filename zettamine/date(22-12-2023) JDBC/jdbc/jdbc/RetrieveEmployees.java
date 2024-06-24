package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetrieveEmployees {

	public static void main(String[] args) {
		retriveEmployees();

	}

	private static void retriveEmployees() {
	 try {	
		Connection con = ConnectionFactory.getDBConnection();
		Statement st = con.createStatement();
		String sql = "select * from emp";
		
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int eno = rs.getInt(1);
			String name = rs.getString(2);
			float sal = rs.getFloat("sal");
			
			String emp = String.format("%-3d | %-15s | %.2f", eno, name, sal);
			System.out.println(emp);
			Thread.sleep(2000);
			//con.close();
		}//while
		rs.close();
		st.close();
		con.close();
	 }catch(Exception ex) {
		 System.out.println(ex);
	 }
	
	}

}
