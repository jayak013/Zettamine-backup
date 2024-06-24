package com.zettamine.java.threads;
class MyTask2 extends Thread{
	@Override
	public void run() {
		System.out.println("inside run() method - " + Thread.currentThread().getName());
	}	
}

public class ThreadTest2 {
	public static void main(String[] args) {
		System.out.println("no of active threads = " + Thread.activeCount());
		System.out.println("main method - " + Thread.currentThread().getName());
		
		Thread t = new MyTask2();
		t.start();
		
		System.out.println("no of active threads = " + Thread.activeCount());
	}
}
