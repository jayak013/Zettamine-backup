package com.zettamine.mt;

public class MTTest {
	public static void main(String[] args) {
		int noOfThreads = Thread.activeCount();
		System.out.println("The number of active threads = "+ noOfThreads);
		
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		System.out.println("name = " + t.getName());
		System.out.println("priority = " + t.getPriority());
		System.out.println("group = " + t.getThreadGroup());
	}
}
