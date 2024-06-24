package com.zettamine.java.threads;

public class ThreadEx1 extends Thread {

	public static void main(String[] args) {
		Thread t1 = new ThreadEx1();
		t1.start(); //Causes this thread to begin execution; the JVM calls the run method of this thread.
		Thread t2 = new ThreadEx1();
		t2.start();
		System.out.println("application completed");
	}
	@Override
	public void run() {
		System.out.println("Running thread job - " + Thread.currentThread().getName());
	}

}
