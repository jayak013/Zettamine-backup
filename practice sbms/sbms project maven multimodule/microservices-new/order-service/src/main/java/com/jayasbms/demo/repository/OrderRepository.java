package com.jayasbms.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayasbms.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Serializable>{

}
