package com.zettamine.java.oops;

public class Inventory {

	public static void main(String[] args) {
		Product prod = new Product();
		prod.setProductId(524163L);
		prod.setProductName("Mobile Phone");
		prod.setProductPrice(75000.5f);
		System.out.println("class type = " + prod.getClass().getName());
		System.out.println("hashCode() = " + prod.hashCode());
		System.out.println("hashCode() in Hexa decimal form = " + Integer.toHexString(prod.hashCode()));
		
		System.out.println(prod);		
	}

}
