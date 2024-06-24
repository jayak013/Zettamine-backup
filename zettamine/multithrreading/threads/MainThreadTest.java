package com.zettamine.java.threads;

public class MainThreadTest {

	public static void main(String[] args) {
		int noOfThreads = Thread.activeCount();
		System.out.println("no of active threads = " + noOfThreads);
		
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		System.out.println("name = " + t.getName());
		System.out.println("priority = " + t.getPriority());
		ThreadGroup tgp = t.getThreadGroup();
		System.out.println(tgp);
		
		t.setName("zetta");
		//t.setPriority(10);
		t.setPriority(11); //java.lang.IllegalArgumentException
		System.out.println(t);
	}

}
