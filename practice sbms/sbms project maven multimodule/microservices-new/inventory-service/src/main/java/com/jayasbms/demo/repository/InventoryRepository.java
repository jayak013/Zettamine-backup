package com.jayasbms.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayasbms.demo.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Serializable>{


	List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
