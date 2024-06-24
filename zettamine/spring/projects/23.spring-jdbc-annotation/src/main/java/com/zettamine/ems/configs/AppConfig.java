package com.zettamine.ems.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:dbconfig.properties")
@ComponentScan(basePackages = "com.zettamine.ems")
public class AppConfig {
	
	@Autowired
	Environment env;
	/*
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		String dc = env.getProperty("jdbc.driverclass");
		String url = env.getProperty("jdbc.url");
		String uname = env.getProperty("jdbc.username");
		String pass = env.getProperty("jdbc.password");
		
		ds.setDriverClassName(dc);
		ds.setUrl(url);
		ds.setUsername(uname);
		ds.setPassword(pass);		
		JdbcTemplate jt = new JdbcTemplate();
		
		return ds;
	}
	*/
	
	@Bean
	JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		String dc = env.getProperty("jdbc.driverclass");
		String url = env.getProperty("jdbc.url");
		String uname = env.getProperty("jdbc.username");
		String pass = env.getProperty("jdbc.password");
		
		ds.setDriverClassName(dc);
		ds.setUrl(url);
		ds.setUsername(uname);
		ds.setPassword(pass);
		
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		
		return jt;
	}

	/*
	 @Bean
	 public DataSource dataSource() {
	  return DataSourceBuilder.create().driverClassName(env.getProperty("jdbc.driverclass"))
		.url(env.getProperty("jdbc.driverclass"))
		.username(env.getProperty("jdbc.username"))
		.password(env.getProperty("jdbc.password")).build();
	 }

	 @Bean
	 public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	  return new JdbcTemplate(dataSource);
	 }
	 */
}
