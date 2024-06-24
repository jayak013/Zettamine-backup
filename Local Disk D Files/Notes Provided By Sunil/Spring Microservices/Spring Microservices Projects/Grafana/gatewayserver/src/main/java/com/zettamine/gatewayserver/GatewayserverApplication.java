package com.zettamine.gatewayserver;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	
	@Bean
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(1, 1, 1);
	}
	
	@Bean
	KeyResolver userKeyResolver() {
	 return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
			.defaultIfEmpty("anonymous");
	}

	@Bean
	public RouteLocator zettaBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		 return routeLocatorBuilder.routes()
					.route(p -> p
						     .path("/zettabank/accounts/**")
						     .filters( f -> f.rewritePath("/zettabank/accounts/(?<segment>.*)","/${segment}")
						    		 		 .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
						    		 		 .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
						    		 				 						.setFallbackUri("forward:/contactSupport")))
						     .uri("lb://ACCOUNTS")) 

					.route(p -> p
						     .path("/zettabank/loans/**")
						     .filters( f -> f.rewritePath("/zettabank/loans/(?<segment>.*)","/${segment}")
						    		 		 .addResponseHeader("statement", "Please contact Branch Manager")
						    		 		 .retry(retryConfig -> retryConfig.setRetries(3)
						    		 				 						   .setMethods(HttpMethod.GET)	
						    		 				 						   .setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true)))
						     .uri("lb://LOANS")) 

					.route(p -> p
						     .path("/zettabank/cards/**")
						     .filters( f -> f.rewritePath("/zettabank/cards/(?<segment>.*)","/${segment}")
						    		 		 .addResponseHeader("due-date", LocalDateTime.now().plusMonths(1L).toString())
						    		 		 .requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())
						    		 				 							  .setKeyResolver(userKeyResolver())))

						     .uri("lb://CARDS")) 
			.build();		
	}
/*	
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
	  return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
					.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
					.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build());
	}
*/	
}
