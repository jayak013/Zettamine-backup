package com.zettamine.java.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeSerializeTest {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("src/com/zettamine/java/io/products.ser");
		ObjectInputStream oin = new ObjectInputStream(in);
		
		Object obj = oin.readObject();
		if(obj instanceof Product) {
			Product prod = (Product)obj;
			System.out.println(prod);
		}
	}

}
