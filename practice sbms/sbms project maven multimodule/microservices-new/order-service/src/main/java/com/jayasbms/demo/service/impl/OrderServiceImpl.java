package com.jayasbms.demo.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.jayasbms.demo.dto.InventoryResponse;
import com.jayasbms.demo.dto.OrderLineItemsDto;
import com.jayasbms.demo.dto.OrderRequest;
import com.jayasbms.demo.model.Order;
import com.jayasbms.demo.model.OrderLineItems;
import com.jayasbms.demo.repository.OrderRepository;
import com.jayasbms.demo.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	private final WebClient.Builder webClientBuilder;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
				.stream()
				.map(this::mapToDto).toList();
		
		order.setOrderLineItemsList(orderLineItems);
		
		List<String> skuCodes = orderRequest.getOrderLineItemsDtoList().stream()
		.map(OrderLineItemsDto::getSkuCode)
		.toList();
		
		System.out.println(skuCodes);
		
		InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
				.uri(uriBuilder -> uriBuilder.path("/api/inventory")
						.queryParam("skuCode",skuCodes).build())
					.retrieve()
					.bodyToMono(InventoryResponse[].class)
					.block();
		
		System.out.println(Arrays.toString(inventoryResponseArray));
		
		boolean result = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
		if(result) orderRepository.save(order);
		else throw new IllegalStateException("product is not in stock, please try again");
		
	}
	
	public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItems.getSkuCode());
		
		return orderLineItems;
	}

}
