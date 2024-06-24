package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnectDemo2 {
	
	public static void main(String[] args) {
		try {
			printEmployess();;
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void saveEmployee() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		String query = "insert into emp values(105,'siva malleswar',25000)";
		int exUp = st.executeUpdate(query);
		System.out.println("No of employees inserted: "+exUp);
		st.close();
		con.close();
	}
	
	public static void printEmployess() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		String query = "select * from emp";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			float sal = rs.getFloat(3);
			System.out.printf("%d | %-15s | %.2f\n",empno,ename,sal);
		}
		rs.close();
		st.close();
		con.close();
	}
	
	
}
