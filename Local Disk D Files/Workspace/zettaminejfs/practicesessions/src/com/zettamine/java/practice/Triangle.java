package com.zettamine.java.practice;

public class Triangle extends Shape {
	
	private int base;
	private int height;

	@Override
	public double area() {
		return base*height*0.5;
	}

	public Triangle(String color, int base, int height) {
		super(color);
		this.base = base;
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
