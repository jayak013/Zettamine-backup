package com.zettamine.java.threads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0; i<empList.size(); i++) {
			Runnable salObj = new SalaryCalculation(empList.get(i));
			executor.submit(salObj);
		}
		System.out.println();
		
		for(Employee emp : empList) {
			System.out.println(emp);
		}
		executor.shutdown();
	}

}
