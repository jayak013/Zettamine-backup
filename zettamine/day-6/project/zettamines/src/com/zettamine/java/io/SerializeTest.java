package com.zettamine.java.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeTest {

	public static void main(String[] args) throws Exception {
		Product product = new Product();
		product.setProductId(10001);
		product.setProductName("Mobile Phone");
		
		OutputStream out = new FileOutputStream("src/com/zettamine/java/io/products.ser");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		
		oos.writeObject(product);
		System.out.println("stock updated");
		
		oos.close();
	}

}
