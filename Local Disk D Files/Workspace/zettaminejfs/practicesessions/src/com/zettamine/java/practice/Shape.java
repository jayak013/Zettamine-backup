package com.zettamine.java.practice;

public abstract class Shape {
	private String color;
	
	public Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double area();
}
