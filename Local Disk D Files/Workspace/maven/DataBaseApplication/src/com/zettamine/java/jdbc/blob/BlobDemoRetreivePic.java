package com.zettamine.java.jdbc.blob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zettamine.java.jdbc.DBConnection;

public class BlobDemoRetreivePic {
	
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from test_blob";
			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//			byte[] picBytes = rs.getBytes(2);
//			new Fileout
//			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
