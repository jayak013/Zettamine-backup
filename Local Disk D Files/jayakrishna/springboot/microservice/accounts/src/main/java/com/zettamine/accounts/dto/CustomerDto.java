package com.zettamine.accounts.dto;

import com.zettamine.accounts.entities.Accounts;

import lombok.Data;

@Data
public class CustomerDto {
	
	private String name;
	private String email;
	private String mobileNumber;
	private AccountsDto accountsDto;
}
