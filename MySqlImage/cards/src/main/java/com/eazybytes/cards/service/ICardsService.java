package com.eazybytes.cards.service;

import org.springframework.stereotype.Service;

import com.eazybytes.cards.dto.CardsDto;

@Service
public interface ICardsService {
	
	/**
	 * 
	 * @param mobile number - Mobile number of the customer
	 */
	void createCard(String mobileNumber);
	
	/**
	 * 
	 * @param mobileNumber - input mobileNumber
	 * @return Card Details based on mobile number
	 */
	CardsDto fetchCard(String mobileNumber);
	
	/**
	 * 
	 * @param cardsDto - cardsDto object
	 * @return boolean indicating if the update of card details is successful or not
	 */
	boolean updateCard(CardsDto cardsDto);
	
	/**
	 * 
	 * @param mobileNumber
	 * @return boolean indicating if the deletion of card details is successful or not
	 */
	boolean deleteCard(String mobileNumber);

}
