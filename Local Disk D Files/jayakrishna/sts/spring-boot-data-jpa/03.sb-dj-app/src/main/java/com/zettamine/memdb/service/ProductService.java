package com.zettamine.memdb.service;

import java.util.List;

import com.zettamine.memdb.entity.Product;

public interface ProductService {
	
	void saveAll(List<Product> products);
	List<Product> getAll();
	
}
