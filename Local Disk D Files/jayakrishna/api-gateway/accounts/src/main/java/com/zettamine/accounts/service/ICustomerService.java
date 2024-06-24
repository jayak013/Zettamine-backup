package com.zettamine.accounts.service;

import com.zettamine.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {
	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
