package com.zettamine.ems;

import java.util.Scanner;

import com.zettamine.ems.dao.EmployeeDAOImpl;
import com.zettamine.ems.dto.Employee;
import com.zettamine.ems.service.EmployeeSercviceImpl;
import com.zettamine.ems.service.EmployeeService;

public class EMSLauncherApp {
	
	private static Scanner scn = new Scanner(System.in);
	private static EmployeeService service = new EmployeeSercviceImpl();
	
	public static void main(String[] args) {
		Employee emp = null;
		while(true) {
			System.out.print("Options Available:\n"
							+ "1. New Employee\n"
							+ "2. Search Employee\n"
							+ "3. Update Employee\n"
							+ "4. Delete Employee\n"
							+ "5. All Employees\n"
							+ "6. Exit\n"
							+ "Pick your option : ");
			int opt = scn.nextInt();
			scn.nextLine();
			switch(opt) {
				case 1:
					System.out.print("\nEnter the Employee id: ");
					int id = scn.nextInt();
					scn.nextLine();
					boolean check = service.isExist(id);
					if(!check) {
						System.out.print("Enter the Employee Name: ");
						String name = scn.nextLine();
						System.out.print("Enter the Employee Salary: ");
						float sal = scn.nextFloat();
						emp = new Employee(id,name,sal);
						service.saveEmployee(emp);
					}else {
						System.out.println("Employee already exists with that id..");
						System.out.println("Details of Existed employee");
						service.getEmployeeById(id);
					}
					break;
				case 2:
					System.out.print("\nEnter the Employee id: ");
					id = scn.nextInt();
					scn.nextLine();
					service.getEmployeeById(id);
					System.out.println();
					break;
				case 3:
					System.out.print("\nEnter the Employee id:");
					id = scn.nextInt();
					scn.nextLine();
					check = service.isExist(id);
					if(check) {
						System.out.println("\nDetails of Existed employee");
						service.getEmployeeById(id);
						System.out.println("\n Enter the details to update");
						emp = new Employee();
						System.out.print("Enter the Employee Name: ");
						emp.setName(scn.nextLine());
						System.out.print("Enter the Employee Salary: ");
						emp.setSalary(scn.nextFloat());
						service.updateEmployeeById(id, emp);
						
					}else {
						System.out.println("No Employees found....");
					}
					System.out.println();
					break;
				case 4:
					System.out.print("\nEnter the Employee id:");
					id = scn.nextInt();
					scn.nextLine();
					check = service.isExist(id);
					if(check) {
						System.out.println("\nDetails of Existed employee");
						service.getEmployeeById(id);
						service.deleteEmployeeById(id);
						System.out.println();
					}else {
						System.out.println("No employee found with that Id..");
					}
					break;
				case 5:
					service.getAllEmployee();
					break;
				case 6:
					System.err.println("Terminated connections");
					service.closeResources();
					System.err.println("Employees App terminated");
					System.exit(0);
					break;
				default:
					System.err.println("Entered a Invalid Option");
			}
		}
	}
	
}
