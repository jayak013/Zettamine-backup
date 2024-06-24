package com.zettamine.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Lazy
@Lazy(value = true)
//@Scope(value = "singleton")
//@Scope(value = "prototype")
@Scope(scopeName = "prototype")
@Component(value = "sunil")
public class User {
	@Value("Sunil")
	private String firstName;
	//@Value("J")
	@Value(value = "${user.lname}")
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

}
