package com.zettamine.mt;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	public static List<Employee> getAllEmployees(){
		Employee e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
		e1 = new Employee(1, "jaya", 8, 22);
		e2 = new Employee(2, "krishna", 8, 19);
		e3 = new Employee(3, "kittu", 9, 18);
		e4 = new Employee(4, "Hari", 8, 20);
		e5 = new Employee(5, "Ganesh", 7, 22);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		return empList;
	}
}
