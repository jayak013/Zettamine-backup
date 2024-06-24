package com.zettamine.java.lambads;

public class RunnableTest {

	public static void main(String[] args) {
		/*
		Thread ct = new Thread(new Runnable() {
			public void run() {
				for(int i=1; i<=5; i++) {
					System.out.println(Thread.currentThread().getName() + " - " + i);
					try {
						Thread.sleep(2000);
					}catch(Exception ex) {}
				}
			}
		});
		*/
		
		/*
		Runnable runRef =  () -> {
			for(int i=1; i<=5; i++) {
				System.out.println(Thread.currentThread().getName() + " - " + i);
				try {
					Thread.sleep(2000);
				}catch(Exception ex) {}
			}
		};
		
		Thread ct = new Thread(runRef);
		*/
		Thread ct = new Thread(() -> {
			for(int i=1; i<=5; i++) {
				System.out.println(Thread.currentThread().getName() + " - " + i);
				try {
					Thread.sleep(2000);
				}catch(Exception ex) {}
			}
		});
		
		ct.start();

	}

}
