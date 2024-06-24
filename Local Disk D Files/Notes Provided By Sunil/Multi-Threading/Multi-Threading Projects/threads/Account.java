package com.zettamine.java.threads;

import java.util.concurrent.TimeUnit;

public class Account {
	private Integer bal;

	public Account(Integer bal) {
		super();
		this.bal = bal;
	}
	
	synchronized public void withdraw(int amt) {
		if(amt > this.bal) {
			System.out.println("release lock....");
			try {
				wait();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
			System.out.println("deposit done.. sufficient fund is available!!");
		}
		this.bal -= amt;
		System.out.println("Rs."+amt+" Debited | Balance: " + this.bal);
	}
	
	synchronized public void deposit(int amt) {
		this.bal += amt;
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		notify();
		System.out.println("Rs."+amt+" Credited | Balance: " + this.bal);
	}
}
