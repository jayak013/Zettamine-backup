package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class RSMetaData {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		DatabaseMetaData dm = con.getMetaData();
		
		System.out.println(dm.getDatabaseProductName());
		System.out.println(dm.getDatabaseProductVersion());
		System.out.println(dm.getDriverName());
		System.out.println(dm.getSQLKeywords());
		System.out.println(dm.getTimeDateFunctions());
		con.close();
	}

}
