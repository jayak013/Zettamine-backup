package com.zettamine.java.day01;

import java.util.Scanner;

public class GenerateBill {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter the no. of pizzas bought: ");
		int pizzaCount = scn.nextInt();
		System.out.print("Enter the no. of puffs bought: ");
		int puffCount = scn.nextInt();
		System.out.print("Enter the no. of cool drinks bought: ");
		int drinksCount = scn.nextInt();
		
		generateBill(pizzaCount,puffCount,drinksCount);
	}
	private static void generateBill(int pizzaCount
								, int puffCount, int drinksCount) {
		int pizzasPrice = pizzaCount*100;
		int puffsPrice = puffCount*20;
		int drinksPrice = drinksCount*10;
		System.out.println("Bill Details");
		System.out.println("Number of Pizzas: \t"+pizzaCount+" \t Cost: "+pizzasPrice);
		System.out.println("Number of Puffs: \t"+puffCount+" \t Cost: "+puffsPrice);
		System.out.println("Number of Cool Drinks: \t"+pizzaCount+" \t Cost: "+drinksPrice+"\n \n");
		
		
		System.out.println("Total Price: "+(pizzasPrice+puffsPrice+drinksPrice));
		System.out.println("ENJOY THE SHOW!!!");
		
	}

	
}
