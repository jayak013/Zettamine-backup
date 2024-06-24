package com.jayasbms.demo.service;

import java.util.List;

import com.jayasbms.demo.dto.InventoryResponse;

public interface InventoryService {
	
	public List<InventoryResponse> isInStock(List<String> skuCode) ;
	
}
