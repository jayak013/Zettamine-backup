package com.zettamine.ems;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.ems.configs.AppConfig;
import com.zettamine.ems.dto.Employee;
import com.zettamine.ems.services.EmployeeService;

public class EMSMain {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
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
				emp = service.searchEmployeeByNo(eno);
				if(emp != null)
					System.out.println(emp);
				else
					System.err.println("No Matching Employee Found!!");
				break;
			case 3:
				service.getAllEmployees();
				break;
			case 4:
				//System.out.println("write logic to update employee");
				emp = new Employee(101, "SANJAY KUMAR", 7500f);
				service.updateEmployee(101, emp);
				break;
			case 5:
				System.out.print("enter employee no to delete: ");
				eno = sc.nextInt();
				emp = service.searchEmployeeByNo(eno);
				if(emp != null) {
					System.out.println(emp);
					
					System.out.print("\ndo you to delete the employee[Y/N]: ");
					String req = sc.next();
					if(req.equalsIgnoreCase("Y"))
						service.deleteEmployeeByNo(eno);
				}
					
				break;
			case 6:
				System.out.println("application designed & developed by");
				System.out.println("\tteam@wipro");
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
