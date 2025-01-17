package com.zettamine.mt;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
	public static void main(String[] args) {
		
		
		Thread t1,t2,t3,t4,t5;
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		t1 = new SalaryCalculation(empList.get(0));
		t2 = new SalaryCalculation(empList.get(1));
		t3 = new SalaryCalculation(empList.get(2));
		t4 = new SalaryCalculation(empList.get(3));
		t5 = new SalaryCalculation(empList.get(4));
		
		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for 5 threads is "+(endTime-startTime));
		
		long startTime1 = System.currentTimeMillis();
		for(Employee e:EmployeeDAO.getAllEmployees()) {
			Thread t = new SalaryCalculation(e);
			t.start();
			try {
				t.join();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("Time taken for single thread is "+(endTime1-startTime1));
	}
}
