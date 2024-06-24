package com.zettamine.boot.security.dao;

import java.util.ArrayList;
import java.util.List;
import com.zettamine.boot.security.models.Product;

public class ProductsDAO {
	
	public static List<Product> getProducts(){
		List<Product> productsList = new ArrayList<Product>(
					List.of(new Product(101, "Mobile"),
							new Product(102, "Computer"), 
							new Product(103, "Laptop") )
				);
		
		return productsList;
	}
}
