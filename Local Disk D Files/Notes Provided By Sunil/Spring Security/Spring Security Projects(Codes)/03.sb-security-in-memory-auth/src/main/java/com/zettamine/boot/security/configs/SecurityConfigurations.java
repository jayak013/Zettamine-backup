package com.zettamine.boot.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfigurations {
	//@Autowired
	//private PasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		http.csrf(csrf -> csrf.disable());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	/*
	@Bean
	public UserDetailsService manageUsers(){
		//System.out.println("inside managerUsers() method");
		
		UserDetails user1 =  User.withUsername("admin")
								 .password("{noop}1234")
								 .roles("ADMIN")
								 .build();
		
		var user2 =  User.withUsername("sunil")
				 .password("{noop}1234")
				 .roles("HR")
				 .build();	
		
		//UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2);
		
		UserDetailsManager users = new InMemoryUserDetailsManager();
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}
	*/
	
	/*
	@Bean
	public UserDetailsService manageUsers(){
		//System.out.println("inside managerUsers() method");
		
		UserDetails user1 =  User.withUsername("admin")
								 .password(getPasswordEncoder().encode("1234"))
								 .roles("ADMIN")
								 .build();
		
		var user2 =  User.withUsername("sunil")
				.password(getPasswordEncoder().encode("1234"))
				 .roles("HR")
				 .build();	
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2);
		return users;
	}
	*/
	
	
	@Bean
	public UserDetailsService manageUsers(){
		//System.out.println("inside managerUsers() method");
		
		UserDetails user1 =  User.withUsername("admin")
								 .password("{noop}1234")
								 .roles("ADMIN")
								 .build();
		
		UserDetails user2 =  User.withUsername("sunil")
				//.password("{bcrypt}"+new BCryptPasswordEncoder().encode("1234"))
				.password("{bcrypt}"+getPasswordEncoder().encode("1234"))
				 .roles("HR","MANAGER")
				//.authorities("HR","MANAGER")
				 .build();	
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2);
		System.out.println(user1.getPassword());
		System.out.println(user2.getPassword());
		System.out.println(user1.getAuthorities());
		System.out.println(user2.getAuthorities());
		return new InMemoryUserDetailsManager(user1, user2);
	}

	//@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
