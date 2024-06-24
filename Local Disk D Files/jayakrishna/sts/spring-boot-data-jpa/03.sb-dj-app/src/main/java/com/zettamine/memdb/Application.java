package com.zettamine.memdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zettamine.memdb.entity.Product;
import com.zettamine.memdb.repository.ProductRepository;
import com.zettamine.memdb.service.ProductService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	private ProductService service;
	
	@Autowired
	public Application(ProductService service) {
		super();
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> products = new ArrayList<>();
		products.add(new Product("Mobile", 28000));
		products.add(new Product("TV", 25000));
		products.add(new Product("Radio", 2700));
		service.saveAll(products);
		service.getAll().stream().forEach(System.out::println);
	}

}
