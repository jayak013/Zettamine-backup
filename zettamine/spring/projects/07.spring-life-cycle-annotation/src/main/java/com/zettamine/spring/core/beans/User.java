package com.zettamine.spring.core.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class User {
	private String firstName;
	private String lastName;

	public User() {
		System.out.println("no argument constructor");
	}

	public User(String firstName, String lastName) {
		System.out.println("2 arguments constructor");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		System.out.println("inside getFirstName() method");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("inside setFirstName() method");
	}

	public String getLastName() {
		System.out.println("inside getLastName() method");
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("inside setLastName() method");
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("user-defined initialization");
	}
	
	@PreDestroy
	public void myDestructor() {
		System.out.println("user-defined destructor");
	}
}
