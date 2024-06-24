package com.zettamine;

import java.lang.reflect.Field;

import com.zettamine.models.Product;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Product prod = new Product();
		System.out.println(prod);
		
		Class<?> prodClass = Class.forName("com.zettamine.models.Product");
		
		Field prodField = prodClass.getDeclaredField("productName");
		prodField.setAccessible(true);
		prodField.set(prod, "Computer");
		System.out.println(prodField.get(prod));
		
		System.out.println(prod);

	}

}
