package com.zettamine.accounts.services;

import com.zettamine.accounts.dto.CustomerDto;

public interface IAccountsService {
	
	/**
	 * 
	 * @param customerDto - CustomerDto Object
	 */
	public void createAccount(CustomerDto customerDto);
	
	public CustomerDto fetchAccount(String mobileNumber);

	public boolean updateAccount(CustomerDto customerDto);
	
}
