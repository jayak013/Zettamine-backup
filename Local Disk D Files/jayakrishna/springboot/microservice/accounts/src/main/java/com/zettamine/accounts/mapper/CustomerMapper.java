package com.zettamine.accounts.mapper;

import java.time.LocalDateTime;

import com.zettamine.accounts.dto.CustomerDto;
import com.zettamine.accounts.entities.Customer;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		return customer;
	}

	public static CustomerDto mapToCustomerDto(Customer customer) {
		CustomerDto mapToCustomerDto = new CustomerDto();
		mapToCustomerDto.setName(customer.getName());
		mapToCustomerDto.setEmail(customer.getEmail());
		mapToCustomerDto.setMobileNumber(customer.getMobileNumber());
		return mapToCustomerDto;
	}
}
