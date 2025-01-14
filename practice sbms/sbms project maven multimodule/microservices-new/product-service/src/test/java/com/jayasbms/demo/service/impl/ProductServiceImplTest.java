package com.jayasbms.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import com.jayasbms.demo.dto.ProductRequest;
import com.jayasbms.demo.dto.ProductResponse;
import com.jayasbms.demo.model.Product;
import com.jayasbms.demo.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
	
	
	@Mock
	private ProductRepository prodRepo;
	
	@Mock
	private Logger log;
	
	@InjectMocks
	private ProductServiceImpl prodService;

	private List<Product> products;
	private Product savedProduct;
	private ProductRequest productRequest;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		
		productRequest = new ProductRequest();
        productRequest.setName("Test Product");
        productRequest.setDescription("Test Description");
        productRequest.setPrice(new BigDecimal(12000.00));
        
        savedProduct = Product.builder()
				.id(100)
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
        products = new ArrayList<>();
		products.add(savedProduct);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		savedProduct = null;
		products = null;
	}

	@Test
	void testCreateProduct() {

		
		Mockito.when(prodRepo.save(any(Product.class))).thenReturn(savedProduct);		
		
		prodService.createProduct(productRequest);
		
		verify(prodRepo).save(any(Product.class));
		
		
		
	}

	@Test
	void testGetAllProducts() {
		
		Mockito.when(prodRepo.findAll()).thenReturn(products);
		
		List<ProductResponse> allProducts = prodService.getAllProducts();
		
		assertEquals(products.get(0).getId(), allProducts.get(0).getId());
		
	}

}
