package com.zettamine.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerialization {
	public static void main(String[] args) throws JsonProcessingException {
		Customer customer = new Customer();
		customer.setCustomerId(101);
		customer.setName("Jaya Krishna");
		customer.setEmail("Jaya@gmail.com");
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String s = objMapper.writeValueAsString(customer);
		System.out.println(s);
		
		String s1 = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
		System.out.println(s1);
		
	}
}
