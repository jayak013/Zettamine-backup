package com.zettamine.spring.core.beans;

public class Customer {
	private String name;
	private Car car;
	private Address address;
	
	public Customer(String name, Car car, Address address) {
		super();
		this.name = name;
		this.car = car;
		this.address = address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer() {
		System.out.println("Customer :: Constructor");
	}
	
	public Customer(Car car) {
		System.out.println("Customer :: OneParamConstructor");
		this.car = car;
	}
	
	public Customer(String name, Car car) {
		System.out.println("Customer :: TwoParamConstructor");
		this.name = name;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", car=" + car + ", address=" + address + "]";
	}
	
	
}
