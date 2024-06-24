package com.zettamine.java.threads1;

public class Employee {
	private int empNo;
	private String empName;
	private double salary;
	private double payPerDay;
	private int noOfDays;

	public Employee(int empNo, String empName, double payPerDay, int noOfDays) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.payPerDay = payPerDay;
		this.noOfDays = noOfDays;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getPayPerDay() {
		return payPerDay;
	}

	public void setPayPerDay(double payPerDay) {
		this.payPerDay = payPerDay;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + ", payPerDay=" + payPerDay
				+ ", noOfDays=" + noOfDays + "]";
	}

}
