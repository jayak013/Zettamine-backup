package com.jayasbms.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@Configuration
public class WebClientConfig {
	
	@Bean
	@LoadBalanced
	WebClient.Builder webClientBuilder() {
		return  WebClient.builder().baseUrl("http://inventory-service");
	}

}
