package com.zettamine.java.threads;
class MyTask1 implements Runnable{
	@Override
	public void run() {
		System.out.println("inside run() method - " + Thread.currentThread().getName());
	}	
}

public class ThreadTest1 {
	public static void main(String[] args) {
		System.out.println("no of active threads = " + Thread.activeCount());
		System.out.println("main method - " + Thread.currentThread().getName());
		
		Runnable runTask = new MyTask1();
		Thread t = new Thread(runTask);
		t.start();
		
		System.out.println("no of active threads = " + Thread.activeCount());
	}

}
