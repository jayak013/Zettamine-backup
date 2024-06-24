package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectDemo {
	
	private static final String USER_NAME = "postgres";
	private static final String PASSWORD = "Jayak@013";
	private static final String URL = "jdbc:postgresql://localhost:5432/Test_DB";
	
	public static void main(String[] args) {
		try {
			createTable();
			System.out.println("DataBase is created.....");
		}catch(Exception e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	}
	
	public static void createTable() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		Statement s = c.createStatement();
		String query = "create table emp(empno int,ename varchar(30),sal decimal(10,2),primary key(empno))";
		boolean execute = s.execute(query);
		System.out.println(execute);
		s.close();
		c.close();
	}
}
