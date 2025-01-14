package com.jayasbms.demo.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayasbms.demo.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Serializable>{


	Optional<Inventory> findBySkuCode();

}
