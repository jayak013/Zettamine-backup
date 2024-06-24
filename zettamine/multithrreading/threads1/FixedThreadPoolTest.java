package com.zettamine.java.threads1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolTest {
	public static void main(String[] args) {
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		long startTime = System.currentTimeMillis();

		// Executor threadPool = Executors.newFixedThreadPool(3);
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		for (Employee emp : empList) {
			Runnable runObj = new SalaryCalculation(emp);
			threadPool.submit(runObj);
		}
		
		threadPool.shutdown();
		try {
			threadPool.awaitTermination(2, TimeUnit.MINUTES);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		for(Employee emp : empList) {
			System.out.println(emp);
		}
		
		
	}
}
