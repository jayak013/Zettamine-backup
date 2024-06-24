package com.zettamine.java.threads1;

public class SalaryCalculation extends Thread {
	private Employee emp;

	public SalaryCalculation(Employee emp) {
		super();
		this.emp = emp;
	}

	@Override
	public void run() {
		calculateSalary();
	}

	public void calculateSalary() {
		double sal = emp.getPayPerDay() * emp.getNoOfDays();
		System.out.println("processing salary of employee: " + emp.getEmpName() + " by: " + Thread.currentThread().getName());
		emp.setSalary(sal);		
		try {
			Thread.sleep(1000);			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
