package com.zettamine.accounts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.accounts.constants.AccountsConstants;
import com.zettamine.accounts.dto.CustomerDto;
import com.zettamine.accounts.dto.ResponseDto;
import com.zettamine.accounts.services.IAccountsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = (MediaType.APPLICATION_JSON_VALUE))
@AllArgsConstructor
public class AccountsController {
	
	private IAccountsService accountsService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
		
		accountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
								.body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
	}
	
	@GetMapping(path = "/fetch")
	public ResponseEntity<CustomerDto> fetchCustomerByMobileNumber(@RequestParam("mobile") String mobileNumber) {
		CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
		return new ResponseEntity<CustomerDto>(customerDto,HttpStatus.OK);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<CustomerDto> updateAccount(@RequestBody CustomerDto customerDto){
		accountsService.updateAccount(customerDto);
		return new ResponseEntity<CustomerDto>(customerDto,HttpStatus.OK);
	}
	
}
