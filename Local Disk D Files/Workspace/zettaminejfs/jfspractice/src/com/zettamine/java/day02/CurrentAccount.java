package com.zettamine.java.day02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrentAccount extends Account{
	private static int transactionCount;



	public CurrentAccount(long acNo, String name, double amount) {
		super(acNo,name,amount);
	}

	@Override
	public double Deposit(double depAmount) {
		transactionCount++;
		return super.Deposit(depAmount);
	}

	@Override
	public double withdraw(double withAmount) {
		transactionCount++;
		return super.withdraw(withAmount);
	}

	@Override
	public String details() {
		transactionCount++;
		return super.details();
	}
	
	public int serviceCharges() {
		int transactionLimit=3;
		if(transactionCount>transactionLimit) {
			int charges = (transactionCount-transactionLimit)*100;
			setAmount(getAmount()-charges);
			System.out.println("Remaining Balance is: "+getAmount());
			return charges;
		}
		return 0;
	}


}
