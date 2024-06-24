package com.zettamine.java.oops;
class Employee{
	private Integer employeeId;
	private String employeeName;
	
	public Employee() {
		System.out.println("no argument constructor");
	}

	public Employee(Integer employeeId, String employeeName) {
		System.out.println("2 arguments constructor");
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	{
		System.out.println("inside {}");
		employeeId=101;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
public class ObjectTest {

	public static void main(String[] args) {
		Employee emp = new Employee();
		System.out.println(emp.getEmployeeId() + " | " + emp.getEmployeeName());
		Employee emp1 = new Employee();
	}

}
