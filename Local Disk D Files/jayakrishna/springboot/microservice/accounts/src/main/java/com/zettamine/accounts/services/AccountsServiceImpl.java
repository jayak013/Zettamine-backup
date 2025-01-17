package com.zettamine.accounts.services;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.zettamine.accounts.constants.AccountsConstants;
import com.zettamine.accounts.dto.AccountsDto;
import com.zettamine.accounts.dto.CustomerDto;
import com.zettamine.accounts.entities.Accounts;
import com.zettamine.accounts.entities.Customer;
import com.zettamine.accounts.exception.CustomerAlreadyExistsException;
import com.zettamine.accounts.exception.ResourceNotFoundException;
import com.zettamine.accounts.mapper.AccountsMapper;
import com.zettamine.accounts.mapper.CustomerMapper;
import com.zettamine.accounts.repositories.AccountsRepository;
import com.zettamine.accounts.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

	private CustomerRepository customerRepo;

	private AccountsRepository accountsRepo;

	@Override
	public void createAccount(CustomerDto customerDto) {
		boolean existsByMobileNumber = customerRepo.existsByMobileNumber(customerDto.getMobileNumber());
		if (existsByMobileNumber) {
			throw new CustomerAlreadyExistsException("Customer is existed with the given mobile number");
		}

		Customer customer = CustomerMapper.mapToCustomer(customerDto);
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("Jaya Krishna");
		customer = customerRepo.save(customer);

		Accounts accounts = new Accounts();
		Long accountNumber = 100000000L + new Random().nextLong(9000000);
		accounts.setAccountNo(accountNumber);
		accounts.setAccountType("Savings");
		accounts.setCustomerId(customer.getCustomerId());
		accounts.setBranchAddress(AccountsConstants.ADDRESS);
		accounts.setCreatedAt(LocalDateTime.now());
		accounts.setCreatedBy("Jaya Krishna");

		accountsRepo.save(accounts);
	}

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepo.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("customer", "mobile number", mobileNumber));
		Accounts accounts = accountsRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account", "Customer ID", customer.getCustomerId().toString()));

		CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);

		AccountsDto accountsDto = AccountsMapper.mapToAccountsDto(accounts);

		customerDto.setAccountsDto(accountsDto);

		return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated = false;

		AccountsDto accountsDto = customerDto.getAccountsDto();

		if (accountsDto != null) {
			Accounts accounts = accountsRepo.findById(accountsDto.getAccountNumber())
					.orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber",
							accountsDto.getAccountNumber().toString()));
			
			accounts = accountsRepo.save(accounts);
			
			Long customerId = accounts.getCustomerId();
			Customer customer = customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));
			
			CustomerMapper.mapToCustomer(customerDto);
			customerRepo.save(customer);
			isUpdated = true;
		}
		
		return isUpdated;
	}

}
