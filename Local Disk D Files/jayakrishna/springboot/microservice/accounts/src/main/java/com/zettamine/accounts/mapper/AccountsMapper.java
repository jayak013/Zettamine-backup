package com.zettamine.accounts.mapper;

import com.zettamine.accounts.dto.AccountsDto;
import com.zettamine.accounts.entities.Accounts;

public class AccountsMapper {

	public static AccountsDto mapToAccountsDto(Accounts accounts) {
		AccountsDto accountsDto = new AccountsDto();
		
		accountsDto.setAccountNumber(accounts.getAccountNo());
		accountsDto.setAccountType(accounts.getAccountType());
		accountsDto.setBranchAddress(accounts.getBranchAddress());
		accountsDto.setCustomerId(accounts.getCustomerId());
		
		return accountsDto;
	}

	public static Accounts mapToAccounts(AccountsDto accountsDto) {
		Accounts accounts = new Accounts();
		
		accounts.setAccountNo(accountsDto.getAccountNumber());
		accounts.setAccountType(accountsDto.getAccountType());
		accounts.setBranchAddress(accountsDto.getBranchAddress());
		accounts.setCustomerId(accountsDto.getCustomerId());
		
		return accounts;
	}

}
