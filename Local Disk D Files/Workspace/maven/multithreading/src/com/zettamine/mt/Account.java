package com.zettamine.mt;

public class Account {
	private Integer bal;

	public Integer getbal() {
		return bal;
	}

	public void setInitialDeposit(Integer bal) {
		this.bal = bal;
	}

	public Account(Integer bal) {
		super();
		this.bal = bal;
	}

	
	synchronized public void deposit(Integer amount) {
		if(amount>bal) {
			System.out.println("less balance");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println("Balance before Deposit : "+bal);
			this.bal+=amount;
			System.out.println("Deposited : " + amount+" | Balance: "+bal+"\n");
	}
	
	synchronized public void withdraw(Integer amount) {
			System.out.println("Balance before Withdraw : "+bal);
			this.bal-=amount;
			System.out.println("Withdrawn : " + amount+" | Balance: "+bal+"\n");
	}
	
}
