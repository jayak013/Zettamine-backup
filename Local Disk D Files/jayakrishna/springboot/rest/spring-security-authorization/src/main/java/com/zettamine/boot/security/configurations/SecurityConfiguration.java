package com.zettamine.boot.security.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());
		
		http.authorizeHttpRequests(request -> request.requestMatchers("/user")
				.hasAnyRole("USER")
				.requestMatchers("/admin")
				.hasRole("ADMIN")
				.requestMatchers("/manager")
				.hasAnyRole("MANAGER","ADMIN")
				.anyRequest().authenticated());
		
		http.httpBasic(Customizer.withDefaults());
		http.formLogin(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService manageUsers() {
		
		UserDetails user1 = User.builder().username("jaya")
						.password(encoder.encode("1234"))
						.roles("ADMIN")
						.build();
		
		return new InMemoryUserDetailsManager(user1);
	}

	
}
