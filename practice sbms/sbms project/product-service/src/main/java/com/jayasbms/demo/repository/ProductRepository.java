package com.jayasbms.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayasbms.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable>{
	
}
