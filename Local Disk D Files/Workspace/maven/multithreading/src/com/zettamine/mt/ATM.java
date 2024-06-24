package com.zettamine.mt;

public class ATM extends Thread{
	Account acc;

	public ATM(Account acc) {
		super();
		this.acc = acc;
	}
	
	public void run() {
		acc.withdraw(7000);
	}
}
