package com.jayasbms.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayasbms.demo.repository.InventoryRepository;
import com.jayasbms.demo.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

	private final InventoryRepository inventoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public boolean isInStock() {
		return inventoryRepository.findBySkuCode().isPresent();
	}

}
