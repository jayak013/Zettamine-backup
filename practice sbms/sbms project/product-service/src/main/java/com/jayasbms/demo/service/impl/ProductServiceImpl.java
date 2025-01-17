package com.jayasbms.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jayasbms.demo.dto.ProductRequest;
import com.jayasbms.demo.dto.ProductResponse;
import com.jayasbms.demo.model.Product;
import com.jayasbms.demo.repository.ProductRepository;
import com.jayasbms.demo.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;
	
	@Override
	public void createProduct(ProductRequest productRequest) {
		
		Product product =  Product.builder()
							.name(productRequest.getName())
							.description(productRequest.getDescription())
							.price(productRequest.getPrice())
							.build();
		
		Product save = productRepository.save(product);
		log.info("product is saved with {}",save.getId());
		logger.info("product is saved with {}",save.getId());
		
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapToProuductResponse).toList();
	}
	
	private ProductResponse mapToProuductResponse(Product product) {
		return ProductResponse.builder()
						.id(product.getId())
						.name(product.getName())
						.description(product.getDescription())
						.price(product.getPrice())
						.build();
	}

}
