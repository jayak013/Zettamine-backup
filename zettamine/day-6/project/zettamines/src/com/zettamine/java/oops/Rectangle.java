package com.zettamine.java.oops;

public class Rectangle extends Shape {
	private int length, breadth;
	  /** 
     * This constructor is to create a Rectangle. 
     * @param color String This show the color of shape 
     * @param length int to specify the length of Rectagngle 
     * @param breadth int - to specify the breadth of rectamge
     */  
	public Rectangle(String color, int length, int breadth) {
		super(color);
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public void area() {
		System.out.println("area of rectangle = " + (this.length * this.breadth));
	}

}
