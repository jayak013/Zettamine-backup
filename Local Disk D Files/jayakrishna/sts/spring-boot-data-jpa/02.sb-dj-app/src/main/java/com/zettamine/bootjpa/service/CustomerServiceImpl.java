package com.zettamine.bootjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zettamine.bootjpa.entities.Customer;
import com.zettamine.bootjpa.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public List<Customer> getAllByContactNameSorted() {
		// Approach-1
//		return repo.findByOrderByCustomerNameAsc();
		return repo.findAll(Sort.by("customerName").descending());
	}

	@Override
	public List<Customer> getAllByCustomerNameAndCustomerNumberSorted() {
//		return repo.findByOrderByCustomerNameAscCustomerNumberDesc();
		return repo.findAll(Sort.by("customerName").ascending()
				.and(Sort.by("customerNumber").descending()));
	}

	@Override
	public List<Customer> getAllContactsBasedOnPagination() {
		int pageNo = 0;
		int pageSize = 4;
		
		
		long count = repo.count();
		
		for(int i = 0;i<Math.ceil(Float.valueOf(count)/pageSize);i++) {
			System.out.println("Page 0"+(i+1)+" of 0"+pageSize+"\n");
			Page<Customer> page = repo.findAll(PageRequest.of(i, pageSize));
			page.getContent().stream().forEach(System.out::println);
		}
		
//		Page<Customer> page = repo.findAll(Pageable.ofSize(pageSize));
//		return page.getContent();
		return null;
	}

}
