package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class BatchExec {

	public static void main(String[] args)throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement st = con.createStatement();
		
		con.setAutoCommit(false);
		
		st.addBatch("insert into emp values(104, 'User-1', 2500)");
		st.addBatch("insert into emp values(105, 'User-2', 3500)");
		//st.addBatch("insert into emp values(105, 'User-3', 4500)");
		st.addBatch("insert into emp values(106, 'User-3', 4500)");
		st.addBatch("update emp set sal = 3750.50 where empno > 103");
		
		try {
			int[] rowsAffected = st.executeBatch();
			for(int n : rowsAffected) {
				System.out.println("employees affected = " + n);
			}
			con.commit();			
		}catch(Exception ex) {
			System.out.println(ex.toString());
			con.rollback();
		}finally {
			st.close();
			con.close();
		}
		
		
	}

}
