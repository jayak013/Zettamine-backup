package com.zettamine.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.jdbctemplate.dto.Employee;
import com.zettamine.jdbctemplate.service.EmpService;

public class MainClass {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("emp-beans.xml");
		
		EmpService service = context.getBean(EmpService.class,"emp-service");
//		int saveEmployee = service.saveEmployee(new Employee(99,"raghava","ragahava@gmail.com",50000));
//		System.out.println(saveEmployee);
		
		Employee emp = service.getEmployeeById(99);
		System.out.println(emp);
		
		service.getAllEmployees().stream().forEach(System.out::println);
	}
}
