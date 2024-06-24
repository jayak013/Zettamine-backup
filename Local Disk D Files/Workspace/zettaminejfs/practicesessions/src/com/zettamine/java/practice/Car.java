package com.zettamine.java.practice;

public class Car {
	
	private String color;
	private String carModelName;
	private Engine engine;
	
	public Car(String color,String carModelName,Engine engine) {
		this.color = color;
		this.carModelName = carModelName;
		this.engine = engine;
	}
	
	public static void main(String[] args) {
		Car c = new Car("Red","Toyota Fortuner",new Engine(20));
		//composition
		System.out.println(c);
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", carModelName=" + carModelName + ", engine=" + engine + "]";
	}
	
	
	
}
