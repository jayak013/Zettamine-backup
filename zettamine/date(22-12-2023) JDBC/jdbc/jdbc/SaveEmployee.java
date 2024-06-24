package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SaveEmployee {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_zettamine", "root", "root");
		
		Statement st = con.createStatement();		
		
		//String sql = "insert into emp values(101, 'Pankaj', 2500.50)";
		String sql = "insert into emp(empno, ename, sal) values(102, 'Shankar', 2500.50),"
				+ "(103, 'Bharath', 5000),(104, 'Mark', 3500.75), (105, 'Sachin', 5750)";
		try {
			int rowsAffected = st.executeUpdate(sql);
			System.out.println("employees saved - " + rowsAffected);
		}catch(Exception ex) {
			System.err.println("Error: " + ex.getMessage());
		}
		//close connection
		
		st.close();
		con.close();
	}

}
