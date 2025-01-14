package com.zettamine.gatewayapi.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Order(1)
@Component
public class RequestTraceFilters implements GlobalFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestTraceFilters.class);
	
	@Autowired
	private FilterUtility filterUtility;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
		if(isCorrelationIdPresents(requestHeaders)) {
			LOGGER.debug("zettabank-correlation-id found in RequestTraceFilter : {}", filterUtility.getCorrelationId(requestHeaders));
		}else {
			String correlationId = generateCorrelationId();
			exchange = filterUtility.setCorrelationId(exchange, correlationId);
			LOGGER.debug("zettabank-correlation-id generated in RequestTraceFilter : {}", correlationId);
		}
		return chain.filter(exchange);
	}
	
	private boolean isCorrelationIdPresents(HttpHeaders requestHeaders) {
		if(filterUtility.getCorrelationId(requestHeaders) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	private String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}
	
	
}
