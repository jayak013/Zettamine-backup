package com.zettamine.java.day02;

public class Loan {
	
	public double calculateLoanAmount(Employee employeeObj) {
		if(employeeObj instanceof PermanentEmployee) {
			employeeObj.calculateSalary();
			return employeeObj.getSalary()*0.15;
		}else {
			employeeObj.calculateSalary();
			return employeeObj.getSalary()*0.1;
		}
	}
	
}
