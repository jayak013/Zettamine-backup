package com.zettamine.bootjpa.service;

import java.util.List;

import com.zettamine.bootjpa.entities.Customer;

public interface CustomerService {
	List<Customer> getAllByContactNameSorted();
	List<Customer> getAllByCustomerNameAndCustomerNumberSorted();
	
	List<Customer> getAllContactsBasedOnPagination();
}
