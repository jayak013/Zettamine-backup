package com.zettamine.java.threads1;

public class ThreadTest2 {

	public static void main(String[] args) {
		System.out.println("no of active threads = " + Thread.activeCount());
		System.out.println("inside main() - " + Thread.currentThread().getName());		
		
		Thread t = new Thread(() -> System.out.println("inside run() - " + 
																	Thread.currentThread().getName()));
		t.start();
		
		System.out.println("no of active threads = " + Thread.activeCount());
	}
}
