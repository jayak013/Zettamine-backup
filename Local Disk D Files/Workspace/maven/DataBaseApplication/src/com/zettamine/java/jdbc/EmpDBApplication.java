package com.zettamine.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpDBApplication {
	
	static Scanner scn = new Scanner(System.in);
	static Connection con = null;
	static Statement st = null;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.print("Available options:\n"
					+ "1. New Employee\n"
					+ "2. Search Employee\n"
					+ "3. Update Employee\n"
					+ "4. Delete Employee\n"
					+ "5. All Employees\n"
					+ "6.Exit\n"
					+ "Enter your option : ");
			int opt = scn.nextInt();
			scn.nextLine();
			switch(opt) {
			case 1:
				System.out.print("\nEnter Employee Number: ");
				int empNo = scn.nextInt();
				scn.nextLine();
				System.out.print("Enter Employee Name: ");
				String eName = scn.nextLine();
				System.out.print("Enter Employee Salary: ");
				float sal = scn.nextFloat();
				saveEmployee(empNo,eName,sal);
				System.out.println();
				break;
			case 2:
				System.out.print("\nEnter the Employee id to search : ");
				int id = scn.nextInt();
				scn.nextLine();
				searchEmployee(id);
				break;
			case 3:
				System.out.print("Enter the Employee id to update : ");
				id = scn.nextInt();
				scn.nextLine();
				updateEmployeeById(id);
				break;
			case 4:
				System.out.println("Enter the Employee id to delete : ");
				id = scn.nextInt();
				scn.nextLine();
				deleteEmployeeById(id);
				break;
			case 5:
				printAllEmployees();
				break;
			case 6:
				exit();
				break;
			default:
				System.err.println("Please enter a valid input....");
			}
		}
	}


	
	private static Statement statementObj() throws ClassNotFoundException, SQLException {
		con = DBConnection.getConnection();
		return con.createStatement();
	}

	private static void exit() throws SQLException {
		System.out.println("Terminated the Application...");
		if(con!=null&&st!=null) {
			st.close();
			con.close();
		}
		System.out.println("Statement resources closed()....");
		System.out.println("Connection resources closed()....");
		System.exit(0);
	}



	private static void printAllEmployees() throws ClassNotFoundException, SQLException {
		st = statementObj();
		String query = "select * from emp";
		ResultSet rs = st.executeQuery(query);
		System.out.printf("\n%-3s | %-15s | %-8s\n","EID","ENAME","SALARY");
		while(rs.next()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			float sal = rs.getFloat(3);
			System.out.printf("%-3d | %-15s | %-8.2f\n",empno,ename,sal);
		}
		rs.close();
		System.out.println();
	}



	private static void saveEmployee(int empNo, String eName, float sal) throws ClassNotFoundException, SQLException {
		con = DBConnection.getConnection();
		Statement st = con.createStatement();
		String query = "insert into emp values("+empNo+",'"+eName+"',"+sal+")";
		int updatedRows = st.executeUpdate(query);
		System.out.println("Employees updated: "+updatedRows);
		st.close();
	}
	
	private static boolean searchEmployee(int id) throws ClassNotFoundException, SQLException {
		Statement st = statementObj();
		String query = "select * from emp where empno = "+id;
		ResultSet rs = st.executeQuery(query);
		boolean check = rs.next();
		if(check) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			float sal = rs.getFloat(3);
			System.out.printf("Employee Details : %d | %-15s | %.2f\n",empno,ename,sal);
		}else System.out.println("No Employee found....\n");
		st.close();
		rs.close();
		System.out.println();
		return check;
	}
	
	
	private static void updateEmployeeById(int id) throws ClassNotFoundException, SQLException {
		if(!searchEmployee(id)) {
			System.out.println("No Employee with this id found on data base");
			return;
		}
		Statement st = statementObj();
		System.out.print("Do you want to update the employee details[Y/N] : ");
		char opt = scn.next().charAt(0);
		String query = null;
		String eName = null;
		if(opt=='y'||opt=='Y') {
			System.out.print("Do you want to update the name[Y/N] : ");
			opt = scn.next().charAt(0);
			scn.nextLine();
			if(opt=='y'||opt=='Y') {
				System.out.print("Enter the name : ");
				 eName = scn.nextLine();
			}else if(opt=='n'||opt=='N') {
				System.out.println("--No Changes Done to name of the employee--");
			}
			System.out.print("Do you want to update the sal[Y/N] : ");
			opt = scn.next().charAt(0);
			scn.nextLine();
			if(opt=='y'||opt=='Y') {
				System.out.print("Enter the sal : ");
				float sal = scn.nextFloat();
				if(eName!=null) {
					query = "update emp set ename = '"+eName+"',sal = "+sal+" where empno = "+id;
				}else {
					query = "update emp set sal = "+sal+" where empno = "+id;
				}
				int exUp = st.executeUpdate(query);
				System.out.println("No of employees updated : "+exUp);
			}else if(opt=='n'||opt=='N') {
				System.out.println("--No Changes Done to sal of the employee--");
			}
			st.close();
		}
	}
	
	private static void deleteEmployeeById(int id) throws ClassNotFoundException, SQLException {
		Statement st = statementObj();
		String query = "delete from emp where empno = "+id;
		int exUp = st.executeUpdate(query);
		if(exUp!=0)System.out.println("Deleted employee rows = "+exUp);
		else System.out.println("No Employee found with this id");
		st.close();
	}


}
