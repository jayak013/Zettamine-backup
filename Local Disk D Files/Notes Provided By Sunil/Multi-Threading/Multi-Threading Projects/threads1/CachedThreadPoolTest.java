package com.zettamine.java.threads1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolTest {

	public static void main(String[] args) {
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		long startTime = System.currentTimeMillis();

		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		for (Employee emp : empList) {
			Runnable runObj = new SalaryCalculation(emp);
			threadPool.submit(runObj);
		}
		
		threadPool.shutdown();
		try {
			threadPool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		for(Employee emp : empList) {
			System.out.println(emp);
		}
		
		
	}

}
