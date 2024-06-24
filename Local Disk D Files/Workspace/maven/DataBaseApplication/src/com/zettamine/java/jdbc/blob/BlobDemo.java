package com.zettamine.java.jdbc.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.zettamine.java.jdbc.DBConnection;

public class BlobDemo {
	
	public static void main(String[] args)  {
		try {
			Connection con = DBConnection.getConnection();
			File f = new File("D:\\images\\animal.jpg");
			FileInputStream fis = new FileInputStream(f);
//			Statement st = con.createStatement();
//			String query = "create table test_blob(pic_id int primary key,picture bytea)";
//			st.execute(query);
			String query = "insert into test_blob values(?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(con.getSchema());
			ps.setInt(1, 101);
			byte[] b = fis.readAllBytes();
			ps.setBytes(2, b);
			int executeUpdate = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
