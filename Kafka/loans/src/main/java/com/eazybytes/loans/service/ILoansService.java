package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;

public interface ILoansService {

	/**
	 * 
	 * @param mobileNumber -- mobile number of the customer
	 */
	void createLoan(String mobileNumber);
	
	/**
	 * 
	 * @param mobileNumber -- input give the mobile number
	 * @return Loan Details based on a given mobileNumber
	 */
	LoansDto fetchLoan(String mobileNumber);
	
	/**
	 * 
	 * @param loansDto - give the loan details as input
	 * @return boolean whether the loan details is updated or not
	 */
	boolean updateLoan(LoansDto loansDto);
	
	/**
	 * 
	 * @param mobileNumber -- input give the mobile number
	 * @return boolean whether the loan details is deleted or not
	 */
	boolean deleteLoan(String mobileNumber);
}
