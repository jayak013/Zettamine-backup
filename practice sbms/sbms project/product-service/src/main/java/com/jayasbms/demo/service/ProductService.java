package com.jayasbms.demo.service;

import java.util.List;

import com.jayasbms.demo.dto.ProductRequest;
import com.jayasbms.demo.dto.ProductResponse;

public interface ProductService {
	
	public void createProduct(ProductRequest productRequest);

	public List<ProductResponse> getAllProducts();
	
}
