package com.jayasbms.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayasbms.demo.dto.ProductRequest;
import com.jayasbms.demo.dto.ProductResponse;
import com.jayasbms.demo.model.Product;
import com.jayasbms.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@WebMvcTest(ProductController.class)
@Slf4j
class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService prodService;
	
	@Autowired
	private ObjectMapper objMapper;
	
	private Product product;
	private ProductResponse prodResponse;
	private ProductRequest prodRequest;
	private List<ProductResponse> productResponseList;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		
		
		prodRequest = ProductRequest.builder().name("iphone 13")
								.description("iphone 13")
								.price(BigDecimal.valueOf(1200.00))
								.build();
		
		product = Product.builder()
						.id(100)
						.name(prodRequest.getName())
						.description(prodRequest.getDescription())
						.price(prodRequest.getPrice())
						.build();
		
		prodResponse = ProductResponse.builder().id(product.getId())
									.name(product.getName())
									.description(product.getDescription())
									.price(product.getPrice())
									.build();
		
		productResponseList = new ArrayList<>();
		
		productResponseList.add(prodResponse);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		prodRequest = null;
		product = null;
		prodResponse = null;
	}

	@Test
	void testCreateProduct() throws Exception {
		
		String prodReqJson = objMapper.writeValueAsString(prodRequest);
				
		mockMvc.perform(post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(prodReqJson))
                .andExpect(status().isCreated());

			
	}

	@Test
	void testGetAllProducts() throws Exception{
		
		String writeValueAsString = objMapper.writeValueAsString(productResponseList);
		
		Mockito.when(prodService.getAllProducts()).thenReturn(productResponseList);
		
		log.info(writeValueAsString);
		
		mockMvc.perform(get("/api/product"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id",is(100)));
	}

}
