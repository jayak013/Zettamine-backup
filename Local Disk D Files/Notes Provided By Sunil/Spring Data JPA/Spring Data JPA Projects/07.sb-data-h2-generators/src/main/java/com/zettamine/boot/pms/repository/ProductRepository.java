package com.zettamine.boot.pms.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.boot.pms.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable> {

}
