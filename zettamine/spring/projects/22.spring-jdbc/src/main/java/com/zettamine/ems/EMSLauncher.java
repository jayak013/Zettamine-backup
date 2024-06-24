package com.zettamine.ems;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.ems.dto.Employee;
import com.zettamine.ems.services.EmployeeService;

public class EMSLauncher {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ems-beans.xml");
		EmployeeService service = (EmployeeService) context.getBean("emp-service");
		
		Employee emp;
		int eno;
		
		while (true) {
			System.out.println("1. New Employee");
			System.out.println("2. Search Employee");
			System.out.println("3. All Employees");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");

			System.out.print("\nenter an option: ");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				emp = createEmployee();
				service.saveEmployee(emp);
				break;
			case 2:
				System.out.print("find employee with employee no: ");
				eno = sc.nextInt();
				service.getEmployeeById(eno);				
				break;
			case 3:
				service.getAllEmployees();
				break;
			case 4:
				System.out.println("write logic to update employee");
				break;
			case 5:
				System.out.print("enter employee no to delete: ");
				eno = sc.nextInt();
				service.deleteEmployeeById(eno);
				break;
			case 6:
				System.out.println("application designed & developed by");
				System.out.println("\tteam@zettamine");
				sc.close();
				System.exit(0);
				break;
			default:
				System.err.println("INVALID OPTION ---- TRY AGAIN");
				break;
			}// switch
			System.out.println(
					"======================================================================================\n");
		}

	}

	private static Employee createEmployee() {
		System.out.print("enter employee no: ");
		int eno = sc.nextInt();
		sc.nextLine();
		
		System.out.print("enter employee name: ");
		String name = sc.nextLine();
		
		System.out.print("enter employee salary: ");
		float sal = sc.nextFloat();
		
		return new Employee(eno, name, sal);
	}

}
