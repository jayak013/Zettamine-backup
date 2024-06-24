package com.zettamine.java.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ProductWithMinDiscount {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter the no of Products:");
		int noOfProds = scn.nextInt();
		System.out.println("Enter all the Products one by one:");
		scn.nextLine();
		findMinDiscount(new String[noOfProds]);
	}

	private static void findMinDiscount(String[] products) {
		
		String[] discounts = new String[products.length];
		int leastOffer = 0;
		for(int i = 0;i < products.length;i++) {
			products[i] = scn.nextLine();
			String[] split = products[i].split(",");
			
			int discountOfProds = (int)(Integer.parseInt(split[1])*
			(Integer.parseInt(split[2])*0.01));
			
			if(i==0) leastOffer = discountOfProds;
			if(leastOffer>discountOfProds) leastOffer = discountOfProds;
			discounts[i] = discountOfProds+","+split[0];
		}
		
		System.out.print("Items with Minimum Discount: ");
		for(int i = 0;i<discounts.length;i++) {
			String[] split = discounts[i].split(",");
			int discount = Integer.parseInt(split[0]);
			if(leastOffer==discount) {
				System.out.print(split[1]+"\t");
			}
		}
	}
	
}
