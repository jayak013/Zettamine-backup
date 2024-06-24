package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedTest {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		
		Scanner sc = new Scanner(System.in);
		
		PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
		
		String req = "";
		do {
			System.out.println("enter employee no, name & salary: ");
			int eno = sc.nextInt();
			String name = sc.next();
			float sal = sc.nextFloat();
			
			pst.setInt(1, eno);
			pst.setString(2, name);
			pst.setFloat(3, sal);
			
			try {
				pst.executeUpdate();
				System.out.println("employee saved ---");
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
			System.out.print("\ndo you want to add new employees? [Y/N]: ");
			req = sc.next();
		}while(req.equalsIgnoreCase("Y"));
		
		sc.close();
		con.close();
	}

}
