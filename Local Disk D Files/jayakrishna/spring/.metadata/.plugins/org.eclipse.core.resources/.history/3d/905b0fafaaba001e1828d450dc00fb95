package com.zettamine.jdbctemplate;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zettamine.jdbctemplate.dto.Employee;
import com.zettamine.jdbctemplate.service.EmpService;


@Configuration
@ComponentScan
@PropertySource("dbconfig.properties")
public class MainClass {
	
	@Autowired
//Environment e;
	ResourceBundle e;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);
		
		EmpService service = context.getBean(EmpService.class);
//		int saveEmployee = service.saveEmployee(new Employee(99,"raghava","ragahava@gmail.com",50000));
//		System.out.println(saveEmployee);
		
		Employee emp = service.getEmployeeById(99);
		System.out.println(emp);
		
		service.getAllEmployees().stream().forEach(System.out::println);
		
		
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName(e.getProperty("driver"));
//		ds.setUrl(e.getProperty("url"));
//		ds.setUsername(e.getProperty("user"));
//		ds.setPassword(e.getProperty("password"));
		
		ds.setDriverClassName(e.getString("driver"));
		ds.setUrl(e.getString("url"));
		ds.setUsername(e.getString("user"));
		ds.setPassword(e.getString("password"));
		
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public ResourceBundle getRsBundle() {
		return ResourceBundle.getBundle("dbconfig");
	}
	
}
