package com.zettamine.boot.security.inmemory.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public UserDetailsService manageUser() {
		
		UserDetails user1 = User.withUsername("jaya")
			.password("{noop}1234")
			.roles("ADMIN","MANAGER")
			.build();
		
		UserDetails user2 = User.withUsername("hari")
			.password("{bcrypt}"+new BCryptPasswordEncoder().encode("hari"))
//			.password("{noop}hari")
			.authorities("MANAGER")
			.build();
		
		UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(user1,user2);
		//userDetailsManager.createUser(user2);
		return userDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		http.csrf(csrf->csrf.disable());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	

	
}
