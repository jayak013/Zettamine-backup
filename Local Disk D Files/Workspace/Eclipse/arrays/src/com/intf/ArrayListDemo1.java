package com.intf;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(101,"jaya",20,30000));
		empList.add(new Employee(102,"krishna",10,20000));
		empList.add(new Employee(103,"varma",20,10000));
		empList.add(new Employee(104,"syed",20,40000));
		empList.add(new Employee(105,"michael",20,30000));
		
		System.out.println("before predicate: " + empList);
		System.out.println(empList.size());
		
		boolean contains = empList.contains(new Employee(101,"jaya",10,30000));
		System.out.println("used contains() to check : " + contains);
		
		int indexOf = empList.indexOf(new Employee(101,"syed",20,40000));
		System.out.println("Index of the employee object if existed: "+indexOf);
		
		empList.removeIf(n->(n.getDno()==20)&&(n.getSalary()>20000));
		System.out.println("after predicate: " + empList);
		System.out.println(empList.size());
		
		
		System.out.println("printing from object array: ");
		Object[] o = empList.toArray();
		for(Object a:o) {
			System.out.println(a);
		}

		System.out.println("printing from Employee array");
		Employee[] array = empList.toArray(new Employee[0]);
		for(Employee emp:array) {
			System.out.println(emp);
		}
	}
}
