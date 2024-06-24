package com.zettamine.java.oops.bank;

public class CurrentAccount extends Account {
	private int transactionsCount;
	private static final int ALLOWED_TRANS_COUNT = 3;
	
	public CurrentAccount(Long accountNo, String accountName, Float balance) {
		super(accountNo, accountName, balance);		
	}

	@Override
	public void deposit(float amt) {
		transactionsCount++;
		super.deposit(amt);
	}

	@Override
	public void withdraw(float amt) {
		transactionsCount++;
		super.withdraw(amt);
	}

	@Override
	public void getDetails() {
		transactionsCount++;
		super.getDetails();
	}
	
	public void serviceCharge() {
		if(transactionsCount > ALLOWED_TRANS_COUNT) {
			int additionalTrans = transactionsCount - ALLOWED_TRANS_COUNT;
			float chargableAmount = additionalTrans * 100;
			super.withdraw(chargableAmount);
		}
	}
}
