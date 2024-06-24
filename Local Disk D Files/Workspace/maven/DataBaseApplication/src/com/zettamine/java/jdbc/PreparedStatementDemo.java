package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String query = "insert into emp values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		char opt = 0;
		int count = 0;
		
		do {
			System.out.println("Enter the Employee Details(id_name_sal): ");
			System.out.print("id: ");
			int id = scn.nextInt();
			System.out.print("ename: ");
			scn.nextLine();
			String name = scn.nextLine();
			System.out.print("sal:");
			float sal = scn.nextFloat();
			scn.nextLine();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setFloat(3, sal);
			count = count+ps.executeUpdate();
			System.out.println("inserted successfully...\n");
			System.out.print("Do you want to add more Employees: ");
			opt = scn.next().charAt(0);
		}while(opt=='y'||opt=='Y');
		System.out.println("\ninserted "+count+" Employee Records into the table");
	}
	
}
