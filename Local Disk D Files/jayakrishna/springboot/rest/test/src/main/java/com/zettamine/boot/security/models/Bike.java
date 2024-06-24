package com.zettamine.boot.security.models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("bike")
public class Bike implements Vehicle {

	@Override
	public void test() {
		System.out.println("Bike Instance");
	}

}
