package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {
	
	/**
	 * 
	 * @param mobileNumber - Input mobile Number
	 * @return customer details based on a given mobileNumber
	 */
	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);

}
