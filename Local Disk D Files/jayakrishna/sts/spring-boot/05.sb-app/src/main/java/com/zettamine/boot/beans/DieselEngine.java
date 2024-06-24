package com.zettamine.boot.beans;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class DieselEngine implements Engine{
	
	public DieselEngine() {
		System.out.println("Diesel Engine :: Constructor");
	}

	@Override
	public boolean startEngine() {
		return new Random().nextBoolean();
	}

}
