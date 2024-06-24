package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableEmployees {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from emp";
		
		ResultSet rs = st.executeQuery(sql);
		System.out.println("is Befor First Record = " + rs.isBeforeFirst());
		System.out.println("is First Record = " + rs.isFirst());
		System.out.println(rs.isAfterLast());
		rs.first();
		System.out.println("is Befor First Record = " + rs.isBeforeFirst());
		System.out.println("is First Record = " + rs.isFirst());
		rs.absolute(3);
		//rs.relative(1);
		rs.relative(-2);
		rs.last();
		
		while(rs.next()) {
			int eno = rs.getInt(1);
			String name = rs.getString(2);
			float sal = rs.getFloat("sal");
			
			String emp = String.format("%3d --> %-3d | %-15s | %.2f",rs.getRow(), eno,name, sal);
			System.out.println(emp);
			Thread.sleep(2000);
		}//while
		
		System.out.println("-------------------------------------------------");
		while(rs.previous()) {
			int eno = rs.getInt(1);
			String name = rs.getString(2);
			float sal = rs.getFloat("sal");
			
			String emp = String.format("%3d --> %-3d | %-15s | %.2f",rs.getRow(), eno,name, sal);
			System.out.println(emp);
			Thread.sleep(2000);
		}//while
	}

}
