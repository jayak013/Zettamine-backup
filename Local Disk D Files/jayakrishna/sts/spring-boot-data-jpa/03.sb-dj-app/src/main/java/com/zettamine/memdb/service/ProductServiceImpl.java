package com.zettamine.memdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.memdb.entity.Product;
import com.zettamine.memdb.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository repo;
	
	
	@Autowired
	public ProductServiceImpl(ProductRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public void saveAll(List<Product> products) {
		repo.saveAll(products);
	}



	@Override
	public List<Product> getAll() {
		return repo.getAllProducts();
	}
	
	

}
