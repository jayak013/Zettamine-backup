package com.zettamine.boot.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.security.dao.ProductDAO;
import com.zettamine.boot.security.dto.Product;

@RestController
public class ProductController {
	
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
	}

	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return dao.getAll();
	}
	
	@GetMapping("/product/{productId}")
	public Product getProductById(@PathVariable Integer productId) {
		return dao.getProductById(productId);
	}
	
	@PostMapping("/new")
	public boolean saveProduct(Product product) {
		return dao.saveProduct(product);
	}
	
}
