package com.zettamine.bootjpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.bootjpa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable>{

	List<Customer> findByOrderByCustomerNameAsc();

	List<Customer> findByOrderByCustomerNameAscCustomerNumberDesc();

}
