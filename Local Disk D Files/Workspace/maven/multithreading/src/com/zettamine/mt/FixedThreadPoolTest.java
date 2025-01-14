package com.zettamine.mt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolTest {

	public static void main(String[] args) {
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

		for (Employee e : empList) {
			Runnable runObj = new SalaryCalculation(e);
			fixedThreadPool.submit(runObj);
		}

		fixedThreadPool.shutdown();

		try {
			fixedThreadPool.awaitTermination(3, TimeUnit.SECONDS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
