package com.zettamine.boot.security.models;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cycle implements Vehicle {

	@Override
	public void test() {
		System.out.println("Cycle Instance created");
	}

}
