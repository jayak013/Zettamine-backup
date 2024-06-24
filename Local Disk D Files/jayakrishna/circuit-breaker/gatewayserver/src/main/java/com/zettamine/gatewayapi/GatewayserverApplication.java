package com.zettamine.gatewayapi;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import jakarta.activation.DataSource;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator zettaBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
			   		    .path("/zettabank/accounts/**")
					    .filters( f -> f.rewritePath("/zettabank/accounts/(?<segment>.*)","/${segment}")
							.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
							.circuitBreaker(config -> config.setName("accountsCircuitBreaker").setFallbackUri("forward:/contactSupport")))
					      
					   .uri("lb://ACCOUNTS"))

							.route(p -> p
								     .path("/zettabank/loans/**")
								     .filters( f -> f.rewritePath("/zettabank/loans/(?<segment>.*)","/${segment}")
								    .circuitBreaker(config -> config.setName("loansCircuitBreaker").setFallbackUri("forward:/contactSupport")))
								     
								.uri("lb://LOANS")) 

							.route(p -> p
								     .path("/zettabank/cards/**")
								     .filters( f -> f.rewritePath("/zettabank/cards/(?<segment>.*)","/${segment}")
								    		 .circuitBreaker(config -> config.setName("cardsCircuitBreaker").setFallbackUri("forward:/contactSupport")))
								.uri("lb://CARDS"))
							.build();
	}
}
