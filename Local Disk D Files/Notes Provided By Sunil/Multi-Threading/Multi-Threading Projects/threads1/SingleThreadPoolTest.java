package com.zettamine.java.threads1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadPoolTest {

	public static void main(String[] args) {
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		long startTime = System.currentTimeMillis();

		ExecutorService threadPool = Executors.newSingleThreadExecutor();

		for (Employee emp : empList) {
			Runnable runObj = new SalaryCalculation(emp);
			threadPool.submit(runObj);
		}
		

		threadPool.shutdown();
		try {
			threadPool.awaitTermination(12, TimeUnit.SECONDS);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
		for(Employee emp : empList) {
			System.out.println(emp);
		}
	}

}
