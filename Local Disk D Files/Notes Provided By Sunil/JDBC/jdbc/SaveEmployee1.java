package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class SaveEmployee1 {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement st = con.createStatement();
		
		String sql = "insert into emp values(106, 'Aanad', 2500.50)";

		try {
			int rowsAffected = st.executeUpdate(sql);
			System.out.println("employees saved - " + rowsAffected);
		} catch (Exception ex) {
			System.err.println("Error: " + ex.getMessage());
		}
		// close connection

		st.close();
		con.close();
	}

}
