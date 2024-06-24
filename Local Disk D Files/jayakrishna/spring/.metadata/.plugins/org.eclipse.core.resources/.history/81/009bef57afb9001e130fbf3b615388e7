package com.zettamine.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Value("${lastName}")
	private String firstName;
	private String lastName;
	
	
	public User() {
		System.out.println("Inside No Argument Constructor");
	}
	
	public User(String firstName, String lastName) {
		System.out.println("Inside Parameterized Constructor");
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("Inside setter of firstName");
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("Inside setter of lastName");
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
