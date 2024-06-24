package com.jayasbms.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayasbms.demo.dto.InventoryResponse;
import com.jayasbms.demo.repository.InventoryRepository;
import com.jayasbms.demo.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

	private final InventoryRepository inventoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		return inventoryRepository.findBySkuCodeIn(skuCode)
				.stream().map(inventory->InventoryResponse.builder()
													.skuCode(inventory.getSkuCode())
													.isInStock(inventory.getQuantity()>0)
													.build()).toList();
	}

}
