package com.zettamine.boot.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zettamine.boot.security.dto.Product;

@Repository

public class ProductDAO {	

	private List<Product> list = new ArrayList<>();
	
	public List<Product> getAll(){
		list.add(new Product(101,"SmartPhone"));
		list.add(new Product(102, "Television"));
		list.add(new Product(103, "Laptop"));
		return list;
	}

	public Product getProductById(Integer productId) {
		return getAll().stream().filter(p->p.productId().equals(productId)).findFirst().get();
	}

	public boolean saveProduct(Product product) {
		list.add(product);
		return true;
	}
	
}
