package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetEx {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement st = con.createStatement();
		String sql = "select * from emp";
		
		ResultSet rs = st.executeQuery(sql);
		
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowSet = factory.createCachedRowSet();
		 
		rowSet.populate(rs);
		//con.close();
		
		rowSet.absolute(2);
		while(rowSet.next()) {
			int eno = rowSet.getInt(1);
			String name = rowSet.getString(2);
			float sal = rowSet.getFloat(3);
			
			String emp = String.format("%-3d | %-15s | %.2f", eno, name, sal);
			System.out.println(emp);
			Thread.sleep(2000);
		}
		con.setAutoCommit(false);
		rowSet.moveToInsertRow();
		rowSet.updateInt(1, 105);
		rowSet.updateString(2,"SRINIVAS");
		rowSet.updateFloat(3, 8888.5f);
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.setTableName("emp");
		rowSet.acceptChanges(con);
		
	}

}
