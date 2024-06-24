package com.zettamine.java.day02;

public class EmployeeLoanCalc {
	
	public static void main(String[] args) {
		Employee e1 = new PermanentEmployee(1, "jaya krishna",343000 );
		Employee e2 = new TemporaryEmployee(2, "kittu", 196,879 );
		Loan loan = new Loan();
		double loanOfTE = loan.calculateLoanAmount(e1);
		double loanOfPE = loan.calculateLoanAmount(e2);
		System.out.println("Permanent Employee Eligibile Loan: "+loanOfPE);
		System.out.println("Temporary Employee Eligibile Loan: "+loanOfTE);
	}
	
}
