package com.zettamine.java.oops;

public class CustomerManagement {

	public static void main(String[] args) {
		var cust = new Customer(100123, "Sanjay");
		System.out.println(cust);
		System.out.println(cust.customerId());
		System.out.println(cust.customerName());
	}

}
