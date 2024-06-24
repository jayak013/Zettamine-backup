package com.zettamine.ums.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory {
	 private static Connection connection = null;
	 
	 public static Connection getConnection() 
	 {
	  if(connection == null) 
	  {	            
		try 
		{
		 ResourceBundle bundle=ResourceBundle.getBundle("com/zettamine/ums/configs/dbconfig");
		 String driver = bundle.getString("jdbc.driver");
		 String url = bundle.getString("jdbc.url");
		 String user = bundle.getString("jdbc.user");
		 String password = bundle.getString("jdbc.password");
		 
		 Class.forName(driver);
		 connection = DriverManager.getConnection(url, user, password);
		} 
		catch(Exception e) {e.printStackTrace();}
	  }
	    return connection;
	 }
}
