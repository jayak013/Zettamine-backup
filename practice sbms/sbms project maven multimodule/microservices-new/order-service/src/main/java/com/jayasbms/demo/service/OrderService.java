package com.jayasbms.demo.service;

import com.jayasbms.demo.dto.OrderRequest;

public interface OrderService {
	
	public void placeOrder(OrderRequest orderRequest);
	
}
