package com.zettamine.jdbctemplate.dto;


public class Employee {
	
	private Integer eid;
	private String ename;
	private String email;
	private double sal;
	
	public Employee() {}	
	
	public Employee(Integer eid, String ename, String email, double sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.sal = sal;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", sal=" + sal + "]";
	}

	public Integer getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}

	public String getEmail() {
		return email;
	}

	public double getSal() {
		return sal;
	}
	
	 
	
}
