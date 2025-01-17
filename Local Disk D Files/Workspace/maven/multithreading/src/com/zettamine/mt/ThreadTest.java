package com.zettamine.mt;

class MyTask1 implements Runnable{
	@Override
	public void run() {
		System.out.println("inside run() - " + Thread.currentThread().getName());
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("Number of Active Threads = " + Thread.activeCount());
		System.out.println("Inside main() - " + Thread.currentThread().getName());
		
		Runnable runObj = new MyTask1();
		Thread t = new Thread(runObj);
		t.start();
		
		System.out.println("Number of Active Threads = "+ Thread.activeCount());
	}
	
}
