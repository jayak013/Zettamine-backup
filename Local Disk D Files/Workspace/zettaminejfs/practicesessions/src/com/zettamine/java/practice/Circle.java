package com.zettamine.java.practice;

public class Circle extends Shape{

	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}

	private int radius;
	
	@Override
	public double area() {
		return 2*3.14*radius*radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	

}
