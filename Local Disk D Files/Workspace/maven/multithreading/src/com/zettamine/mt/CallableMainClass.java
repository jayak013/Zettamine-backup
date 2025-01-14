package com.zettamine.mt;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMainClass {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService tPool = Executors.newSingleThreadExecutor();
		
		Future<Integer> submit = tPool.submit(()->{
			return 275;
		});
		System.out.println(submit.get());
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		Future<List<Employee>> submit2 = tPool.submit(()->{
			return empList;
		});
		
		
		
	}
	
}
