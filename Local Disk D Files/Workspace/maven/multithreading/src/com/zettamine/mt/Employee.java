package com.zettamine.mt;


public class Employee {
	
	private int empNo;
	private String empName;
	private int wagesPerDay;
	private int noOfDays;
	private int salary;
	
	
	
	public Employee(int empNo, String empName, int wagesPerDay, int noOfDays) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.wagesPerDay = wagesPerDay;
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
	public int getWagesPerDay() {
		return wagesPerDay;
	}
	public void setWagesPerDay(int wagesPerDay) {
		this.wagesPerDay = wagesPerDay;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", wagesPerDay=" + wagesPerDay + ", noOfDays="
				+ noOfDays + ", salary=" + salary + "]\n"
						+ "current thread : "+Thread.currentThread().getName();
	}
	
	
}
