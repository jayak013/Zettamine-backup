package com.zettamine.gatewayapi;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

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
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
									.uri("lb://ACCOUNTS")) 

							.route(p -> p
								     .path("/zettabank/loans/**")
								     .filters( f -> f.rewritePath("/zettabank/loans/(?<segment>.*)","/${segment}"))
								.uri("lb://LOANS")) 

							.route(p -> p
								     .path("/zettabank/cards/**")
								     .filters( f -> f.rewritePath("/zettabank/cards/(?<segment>.*)","/${segment}"))
								.uri("lb://CARDS"))
							.build();
	}
}
