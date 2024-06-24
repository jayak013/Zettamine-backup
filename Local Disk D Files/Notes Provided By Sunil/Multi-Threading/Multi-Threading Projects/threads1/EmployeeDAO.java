package com.zettamine.java.threads1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	public static List<Employee> getAllEmployees() {
		Employee emp1 = new Employee(101, "Employee-1", 10000, 22);
		Employee emp2 = new Employee(102, "Employee-2", 9000, 20);
		Employee emp3 = new Employee(103, "Employee-3", 8000, 21);
		Employee emp4 = new Employee(104, "Employee-4", 7500, 19);
		Employee emp5 = new Employee(105, "Employee-5", 12000, 22);
		Employee emp6 = new Employee(106, "Employee-6", 11000, 15);
		Employee emp7 = new Employee(107, "Employee-7", 10000, 22);
		Employee emp8 = new Employee(108, "Employee-8", 10000, 22);
		Employee emp9 = new Employee(109, "Employee-9", 10000, 20);
		Employee emp10 = new Employee(110, "Employee-10", 6000, 19);

		List<Employee> empList = new ArrayList<Employee>();

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		empList.add(emp7);
		empList.add(emp8);
		empList.add(emp9);
		empList.add(emp10);

		return empList;
	}
}
