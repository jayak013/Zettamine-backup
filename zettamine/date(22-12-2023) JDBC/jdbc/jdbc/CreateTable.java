package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//initialize JDBC driver of MySQL
		Class.forName("com.mysql.cj.jdbc.Driver");		
		
		//create a connection with db_zettamine
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_zettamine", "root", "root");
		
		//create a provision for passing SQL queries
		Statement st = con.createStatement();
		
		//pass the SQL Query and process result
		String sql = "create table emp(empno int(5), ename varchar(30), sal float(10,2), primary key(empno))";
		
		try {
			st.execute(sql);
			System.out.println("Database Table Created!!");
		}catch(Exception ex) {
			System.err.println("Error: " + ex.getMessage());
		}
		//close connection
		
		st.close();
		con.close();
	}
}
