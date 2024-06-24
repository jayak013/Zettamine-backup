package com.zettamine.java.threads1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadTest3 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService tPool = Executors.newSingleThreadExecutor();
		
		Callable<Integer> calTask = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				try {
					TimeUnit.SECONDS.sleep(2);
				}catch(Exception ex) {}
					return 2575;
			}			
		};
		
		Future<Integer> respData =  tPool.submit(calTask);
		tPool.shutdown();
		try {
			System.out.println(respData.get());
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		System.out.println("main method ends!!");
	}

}
