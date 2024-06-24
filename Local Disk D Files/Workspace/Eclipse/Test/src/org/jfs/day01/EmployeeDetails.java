package org.jfs.day01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.jfs.util.Employees;

public class EmployeeDetails {
	
	private static int count;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	
	public static void main(String[] args){
//		Employee e1 = new Employee(101, "Ajay", 10,Designation.SOFTWARE_ENGINEER);
//		Employee e2 = new Employee(102, "Vijay", 10,Designation.SENIOR_SOFTWARE_ENGINEER);
//		Employee e3 = new Employee(103, "Kishore", 20,Designation.DELIVERY_MANAGER);  
//		Employee e4 = new Employee(104, "Beena", 20,Designation.PROJECT_LEAD);
//		Employee e5 = new Employee(e1);
//		Employee e6 = new Employee(106, "Sudha", 30,Designation.TECHNICAL_LEAD);
//		Employee e7 = new Employee(107, "Abigail", 30,Designation.SENIOR_SOFTWARE_ENGINEER);
//		Employee e8 = new Employee(108, "Prateesh", 40,Designation.PROJECT_LEAD);
//		Employee e9 = e1;
//		Employee e10 = new Employee(110, "Zaheer", 10,Designation.SENIOR_SOFTWARE_ENGINEER);
//		Employee e11 = new Employee(111, "Vishal", 50,Designation.SOFTWARE_ENGINEER);
//		Employee e12 = new Employee(112, "Manoj", 40,Designation.SENIOR_SOFTWARE_ENGINEER);		
		
//		Employee e1 = Employees.getEmployeeForDesignationBuckets(101, "Ajay", 10,Designation.SOFTWARE_ENGINEER);
//		Employee e2 = Employees.getEmployeeForDesignationBuckets(102, "Vijay", 10,Designation.SENIOR_SOFTWARE_ENGINEER);
//		Employee e3 = Employees.getEmployeeForDesignationBuckets(103, "Kishore", 20,Designation.DELIVERY_MANAGER);  
//		Employee e4 = Employees.getEmployeeForDesignationBuckets(104, "Beena", 20,Designation.PROJECT_LEAD);
//		Employee e5 = new Employee(e1);
//		Employee e6 = Employees.getEmployeeForDesignationBuckets(106, "Sudha", 30,Designation.TECHNICAL_LEAD);
//		Employee e7 = Employees.getEmployeeForDesignationBuckets(107, "Abigail", 30,Designation.SENIOR_SOFTWARE_ENGINEER);
//		Employee e8 = Employees.getEmployeeForDesignationBuckets(108, "Prateesh", 40,Designation.PROJECT_LEAD);
//		Employee e9 = e1;
//		Employee e10 = Employees.getEmployeeForDesignationBuckets(110, "Zaheer", 10,Designation.SENIOR_SOFTWARE_ENGINEER);
//		Employee e11 = Employees.getEmployeeForDesignationBuckets(111, "Vishal", 50,Designation.SOFTWARE_ENGINEER);
//		Employee e12 = Employees.getEmployeeForDesignationBuckets(112, "Manoj", 40,Designation.SENIOR_SOFTWARE_ENGINEER);	
		
  		Employee e1 = Employees.getEmployeeForDeptBucketsCustom(101, "Ajay", 10,Designation.SOFTWARE_ENGINEER);//UPCASTING
		Employee e2 = Employees.getEmployeeForDeptBucketsCustom(102, "Vijay", 10,Designation.SENIOR_SOFTWARE_ENGINEER);
		Employee e3 = Employees.getEmployeeForDeptBucketsCustom(103, "Kishore", 20,Designation.DELIVERY_MANAGER);  
		Employee e4 = Employees.getEmployeeForDeptBucketsCustom(104, "Beena", 20,Designation.PROJECT_LEAD);
		Employee e5 = new Employee(e1);//Direct SuperClass Object
		Employee e6 = Employees.getEmployeeForDeptBucketsCustom(106, "Sudha", 30,Designation.TECHNICAL_LEAD);
		Employee e7 = Employees.getEmployeeForDeptBucketsCustom(107, "Abigail", 30,Designation.SENIOR_SOFTWARE_ENGINEER);
		Employee e8 = Employees.getEmployeeForDeptBucketsCustom(108, "Prateesh", 40,Designation.PROJECT_LEAD);
		Employee e9 = e1;
		Employee e10 = Employees.getEmployeeForDeptBucketsCustom(110, "Zaheer", 10,Designation.SENIOR_SOFTWARE_ENGINEER);
		Employee e11 = Employees.getEmployeeForDeptBucketsCustom(111, "Vishal", 50,Designation.SOFTWARE_ENGINEER);
		Employee e12 = Employees.getEmployeeForDeptBucketsCustom(112, "Manoj", 40,Designation.SENIOR_SOFTWARE_ENGINEER);	
		
		Set<Employee> empSet = new HashSet<>();
		
		addEmp(empSet, e1);
		addEmp(empSet, e2);
		addEmp(empSet, e3);
		addEmp(empSet, e4);
		addEmp(empSet, e5);
		addEmp(empSet, e6);
		addEmp(empSet, e7);
		addEmp(empSet, e8);
		addEmp(empSet, e9);
		addEmp(empSet, e10);
		addEmp(empSet, e11);
		addEmp(empSet, e12);
		
		scanner.close();
		System.out.println("End of the program");
		
	}
	public static void addEmp(Set<Employee> set,Employee emp) {
		count++;
		System.out.println("Employee reference variable being processed is e" + count);
		
		System.out.println("Hit enter to continue:");
		if(scanner.nextLine() != null) {
			set.add(emp);
			System.out.println("\n No. of elements in empSet:" + set.size());
		}
	}
	
	private static Employee getEmployeeForDeptBuckets(int eno,String ename,int deptNo, Designation desg) {
		return new Employee(eno, ename, deptNo, desg) {
			@Override
			public int hashCode() {
				return deptNo;
			}
		};
	}
}
