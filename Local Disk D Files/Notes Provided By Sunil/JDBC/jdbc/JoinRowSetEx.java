package com.zettamine.java.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetEx {

	public static void main(String[] args) throws Exception {
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
		
		rowSet.setUrl("jdbc:mysql://localhost:3306/db_zettamine");  
		rowSet.setUsername("root");  
		rowSet.setPassword("root");  
		           
		rowSet.setCommand("select * from emp");  
		rowSet.execute();  
		
		while(rowSet.next()) {
			int eno = rowSet.getInt(1);
			String name = rowSet.getString(2);
			float sal = rowSet.getFloat(3);
			
			String emp = String.format("%-3d | %-15s | %.2f", eno, name, sal);
			System.out.println(emp);
			Thread.sleep(2000);
		}
		rowSet.close();
	}

}
