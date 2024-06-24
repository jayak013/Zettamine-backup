package com.zettamine.boot.beans;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine{
	
	public PetrolEngine() {
		System.out.println("Petrol Engine :: Constructor");
	}

	@Override
	public boolean startEngine() {
		return new Random().nextBoolean();
	}
	
}
