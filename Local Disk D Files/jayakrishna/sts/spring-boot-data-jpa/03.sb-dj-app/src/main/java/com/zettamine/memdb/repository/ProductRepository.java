package com.zettamine.memdb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.memdb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable>{

	List<Product> getAllProducts();

}
