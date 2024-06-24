package com.zettamine.java.practice;

import java.util.Scanner;

public class DrawingApp {
	
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		Shape shape = null;
		System.out.print("Which shape do you want to work with?[1. Rectangle | 2.Circle | 3. Triangle]: ");
		int option = scn.nextInt();
		String color = "";
		switch(option) {
			case 1:
				System.out.print("Enter the colour of Rectangle: ");
				color = scn.next();
				System.out.print("Enter the length of Rectangle: ");
				int length = scn.nextInt();
				System.out.print("Enter the breadth of Recatngle: ");
				int breadth = scn.nextInt();
				shape = new Rectangle(color,length,breadth);
				printTheDetails(shape);
				break;
			case 2:
				System.out.print("Enter the colour of Circle: ");
				color = scn.next();
				System.out.print("Enter the radius of Circle: ");
				int radius = scn.nextInt();
				shape = new Circle(color,radius);
				printTheDetails(shape);
				break;
			case 3:
				System.out.print("Enter the colour of Triangle: ");
				color = scn.next();
				System.out.print("Enter the height of Triangle: ");
				int height = scn.nextInt();
				System.out.print("Enter the base of Triangle: ");
				int base = scn.nextInt();
				shape = new Triangle(color,base,height);
				printTheDetails(shape);
				break;
			default:
				System.err.println("Invalid shape selection :: try agian----closed the app.");
		}
		scn.close();
	}
	

	private static void printTheDetails(Shape shape) {
		String className = shape.getClass().getSimpleName();
		System.out.println("=".repeat(10)+" SHAPE SELECTED : "+className.toUpperCase()+"=".repeat(10));
		System.out.println("Color of \""+className+"\" is "+shape.getColor());
		System.out.print("Change the Color(Y/N):");
		char opt = scn.next().charAt(0);
		if(opt=='y'||opt=='Y') {
			System.out.print("Enter the new color: ");
			shape.setColor(scn.next());
			System.out.println("updated color of \""+className+"\" is "+shape.getColor());
			System.out.println("Area of "+className+" is: "+shape.area());
		}else {
			System.out.println("Area of "+className+" is: "+shape.area());
		}
	}
	
}
