package newassignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductWithMinDiscount {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter the no of Products:");
		int noOfProds = scn.nextInt();
		findMinDiscount(new String[noOfProds]);
	}

	private static void findMinDiscount(String[] products) {
		
		String[] discounts = new String[products.length];
		
		for(int i = 0;i < products.length;i++) {
			String product = scn.nextLine();
			products[i] = product;
			String[] split = product.split(",");
			System.out.println(products[0]);
//			discounts[i] = Integer.parseInt(split[1])*
//						Integer.parseInt(split[2])+","+split[0];
		}
		Arrays.sort(discounts);
		for(int i = 0;i<discounts.length;i++) {
			String[] split = discounts[i].split(",");
			int a = Integer.parseInt(split[0]);
			if(a== Integer.parseInt(split[0])) {
				System.out.print(split[1]+"\t");
			}
		}
		
	}
	
}
