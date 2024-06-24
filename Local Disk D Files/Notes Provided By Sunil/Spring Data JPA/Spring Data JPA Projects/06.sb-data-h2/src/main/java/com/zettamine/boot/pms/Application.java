package com.zettamine.boot.pms;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.boot.pms.entity.Product;
import com.zettamine.boot.pms.repository.ProductRepository;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		List<Product> products = Arrays.asList(
					new Product(101, "Television", 63500f),
					new Product(102, "Computer", 45750f),
					new Product(103, "Mobile", 72500f)
				);
		
		repo.saveAll(products);
		
		List<Product> productsInStock = repo.findAll();
		productsInStock.forEach(prod -> LOGGER.info(prod.toString()));
		
		//context.close();
	}

}
