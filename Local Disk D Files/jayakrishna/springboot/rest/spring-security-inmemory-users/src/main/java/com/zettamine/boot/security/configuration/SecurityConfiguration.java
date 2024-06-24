package com.zettamine.boot.security.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//	@Autowired
//	private DataSource dataSource;
	
	@Bean
	public UserDetailsService manageUsers() {

		UserDetails user1 = User.builder().username("jaya").password(getPasswordEncoder().encode("1234")).roles("ADMIN",
				"MANAGER").build();

		UserDetails user2 = User.builder().username("hari").password(getPasswordEncoder().encode("4321"))
				.roles("MANAGER").build();

		 JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource());
		 jdbcUserDetailsManager.createUser(user1);
		 jdbcUserDetailsManager.createUser(user2);
		 return jdbcUserDetailsManager;
	}

	private DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request -> request.requestMatchers("/h2-console/**").permitAll().anyRequest().authenticated());
		http.csrf(csrf -> csrf.disable());
		http.headers(header->header.frameOptions(frame->frame.sameOrigin()));
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}

}
