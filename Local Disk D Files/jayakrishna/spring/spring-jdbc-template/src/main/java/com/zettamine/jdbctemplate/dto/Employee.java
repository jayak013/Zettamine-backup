package com.zettamine.jdbctemplate.dto;

public class Employee {
	
	private Integer emp_id;
	private String emp_name;
	private String emp_email;
	private double sal;
	
	public Employee() {}	
	


	public Employee(Integer emp_id, String emp_name, String emp_email, double sal) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.sal = sal;
	}



	public Integer getEmp_id() {
		return emp_id;
	}



	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}



	public String getEmp_name() {
		return emp_name;
	}



	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}



	public String getEmp_email() {
		return emp_email;
	}



	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}



	public double getSal() {
		return sal;
	}



	public void setSal(double sal) {
		this.sal = sal;
	}



	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", sal=" + sal
				+ "]";
	}




	
	 
	
}
