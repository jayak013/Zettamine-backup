package com.zettamine.accounts.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.accounts.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {
	
	boolean existsByMobileNumber(String mobileNumber);
	
	Optional<Customer> findByMobileNumber(String mobileNumber);
	
}
