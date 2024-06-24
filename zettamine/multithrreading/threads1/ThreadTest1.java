package com.zettamine.java.threads1;
class MyTask1 implements Runnable{
	@Override
	public void run() {
		System.out.println("inside run() - " + Thread.currentThread().getName());		
	}
}

public class ThreadTest1 {

	public static void main(String[] args) {
		System.out.println("no of active threads = " + Thread.activeCount());
		System.out.println("inside main() - " + Thread.currentThread().getName());		
		
		Runnable runObj = new MyTask1();;
		Thread t = new Thread(runObj);
		t.start();
		
		System.out.println("no of active threads = " + Thread.activeCount());
	}

}
