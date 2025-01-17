package com.zettamine.accounts.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zettamine.accounts.dto.AccountsDto;
import com.zettamine.accounts.dto.CardsDto;
import com.zettamine.accounts.dto.CustomerDetailsDto;
import com.zettamine.accounts.dto.LoansDto;
import com.zettamine.accounts.entity.Accounts;
import com.zettamine.accounts.entity.Customer;
import com.zettamine.accounts.exception.ResourceNotFoundException;
import com.zettamine.accounts.mapper.AccountsMapper;
import com.zettamine.accounts.mapper.CustomerMapper;
import com.zettamine.accounts.repository.AccountsRepository;
import com.zettamine.accounts.repository.CustomerRepository;
import com.zettamine.accounts.service.ICustomerService;
import com.zettamine.accounts.service.client.CardsFeignClient;
import com.zettamine.accounts.service.client.LoansFeignClient;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
	private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private LoansFeignClient loansFeignClient;
    private CardsFeignClient cardsFeignClient;
    
	@Override
	public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

	}

}
