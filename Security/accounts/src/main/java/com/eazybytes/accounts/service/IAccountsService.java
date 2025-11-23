package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

	/**
	 * 
	 * @param customerDto - CustomerDto Object
	 */
	void createAccount(CustomerDto customerDto);
	
	/**
	 * 
	 * @param mobileNumber - Input mobile number
	 * @return Account details based on given mobile number
	 */
	CustomerDto fetchAccount(String mobileNumber);
	
	/**
	 * 
	 * @param customerDto - CustomerDto Object
	 * @return boolean indicating if the update of Account details is successful or not
	 */
	boolean updateAccount(CustomerDto customerDto);
	
	/**
	 * 
	 * @param mobileNumber
	 * @return boolean indicating if the delete of Account details is successful or not
	 */
	boolean deleteAccount(String mobileNumber);
}
