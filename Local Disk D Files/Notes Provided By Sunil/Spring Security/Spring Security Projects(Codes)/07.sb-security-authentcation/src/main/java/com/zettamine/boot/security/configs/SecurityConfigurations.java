package com.zettamine.boot.security.configs;

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
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> request.requestMatchers("/home","/care")
												.permitAll()
												.anyRequest()
												.authenticated());
		http.csrf(csrf -> csrf.disable());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public UserDetailsService manageUsers(){
		UserDetails user1 =  User.withUsername("admin")
								 .password(encoder.encode("1234"))
								 .roles("ADMIN")
								 .build();
		
		UserDetails user2 =  User.builder()
						 .username("sunil")
						 .password(encoder.encode("password"))	
						 .roles("HR","MANAGER")
						 .build();	
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2);
		System.out.println(user1.getPassword());
		System.out.println(user2.getPassword());
	
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
