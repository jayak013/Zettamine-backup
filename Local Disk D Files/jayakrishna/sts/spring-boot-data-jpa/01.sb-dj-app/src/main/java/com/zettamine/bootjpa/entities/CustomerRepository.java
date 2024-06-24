package com.zettamine.bootjpa.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

/**
 * 
 */

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	/**
	 * @param custName - String Type
	 * @return Optional Object of Customer
	 * For this method implementation is provided implicitly by dataJPA &
	 * The finder methods name after 'findBy' should match the any variable name of the entity class
	 */
	Optional<Customer> findByCustomerName(String custName);
	
	Optional<Customer> findByCustomerNumber(String custNumber);
	
	Optional<Customer> findByCustomerNameAndCustomerNumber(String custName,String custNumber);
	
	Optional<Customer> findByCustomerNameOrCustomerNumber(String custName,String custNumber);
	
	@Transactional
	Integer deleteByCustomerName(String custName);
	
	@Query("from Customer where mod(id,2)=0")
	List<Customer> findEvenId();
	
	
	
}
