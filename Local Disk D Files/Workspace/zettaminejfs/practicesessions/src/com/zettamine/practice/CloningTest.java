package com.zettamine.practice;

public class CloningTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee(1, "jaya", new Address("Hyd"));
//		Employee e2 = new Employee(e1);
//		e1.address.address = "Vizag";
		Employee e2 = e1.clone();
		e1.address.address = "Vizag";
		e1.id = 0;
		System.out.println(e1);
		System.out.println(e2);
		
	}
}

class Employee implements Cloneable{
	int id;
	String name;
	Address address;
	
	
	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Employee(Employee e) {
		this.id = e.id;
		this.name = e.name;
		this.address = new Address(e.address.address);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	public Employee clone() throws CloneNotSupportedException {
		return new Employee(this.id,this.name,new Address(this.address.address));
	}
	
	
}
class Address{
	String address;

	@Override
	public String toString() {
		return address;
	}

	public Address(String address) {
		super();
		this.address = address;
	}
	
	
	
}
