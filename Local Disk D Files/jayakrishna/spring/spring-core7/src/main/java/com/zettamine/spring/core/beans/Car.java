package com.zettamine.spring.core.beans;

public class Car {
	
	private String model;
	private Integer cost;
	
	public Car() {
		System.out.println("Car :: Constructor");
	}
	
	public Car(String model, Integer cost) {
		System.out.println("Car :: ParamConstructor");
		this.model = model;
		this.cost = cost;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "model=" + model + ", cost=" + cost;
	}

	
	
	
	
}
