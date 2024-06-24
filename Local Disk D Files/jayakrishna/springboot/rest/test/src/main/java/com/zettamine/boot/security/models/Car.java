package com.zettamine.boot.security.models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Car implements Vehicle{

	@Override
	public void test() {
		System.out.println("Car Instance");
	}
	
	
}
