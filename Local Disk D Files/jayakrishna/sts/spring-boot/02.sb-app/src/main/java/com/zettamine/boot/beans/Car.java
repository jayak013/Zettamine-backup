package com.zettamine.boot.beans;

import org.springframework.stereotype.Component;

@Component(value = "mycar")
public class Car {
	
	public Car() {
		System.out.println("Car :: Constructor");
	}
	
	public void startJourney() {
		System.out.println("$$$-->HAPPY JOURNEY<--$$$");
	}
}
