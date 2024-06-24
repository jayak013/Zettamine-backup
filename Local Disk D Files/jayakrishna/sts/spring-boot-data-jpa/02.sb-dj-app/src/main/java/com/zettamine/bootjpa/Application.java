package com.zettamine.bootjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zettamine.bootjpa.entities.Customer;
import com.zettamine.bootjpa.service.CustomerService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private CustomerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		List<Customer> list = service.getAllByContactNameSorted();
		
//		List<Customer> list = service.getAllByCustomerNameAndCustomerNumberSorted();
		
		List<Customer> list = service.getAllContactsBasedOnPagination();
		System.out.println();
//		list.stream().forEach(System.out::println);
		
	}

}
