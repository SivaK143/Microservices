package com.eazybytes.cards.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.eazybytes.cards.constants.CardConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsRepository;
import com.eazybytes.cards.service.ICardsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

	private CardsRepository cardsRepository;

	@Override
	public void createCard(String mobileNumber) {
		Optional<Cards> optionCards = cardsRepository.findByMobileNumber(mobileNumber);
		if (optionCards.isPresent()) {
			throw new CardAlreadyExistsException("Card already registered with given mobileNumber " + mobileNumber);
		}
		cardsRepository.save(createNewCard(mobileNumber));
	}

	private Cards createNewCard(String mobileNumber) {
		Cards newCard = new Cards();
		long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
		newCard.setCardNumber(Long.toString(randomCardNumber));
		newCard.setMobileNumber(mobileNumber);
		newCard.setCardType(CardConstants.CREDIT_CARD);
		newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
		newCard.setAmountUsed(0);
		newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
		return newCard;
	}

	@Override
	public CardsDto fetchCard(String mobileNumber) {
		Cards card = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
		return CardsMapper.mapToCardsDto(card, new CardsDto());
	}

	@Override
	public boolean updateCard(CardsDto cardsDto) {
		Cards card = cardsRepository.findByCardNumber(cardsDto.getCardNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
		CardsMapper.mapToCards(cardsDto, card);
		cardsRepository.save(card);
		return true;
	}

	@Override
	public boolean deleteCard(String mobileNumber) {
		
		Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
		cardsRepository.deleteById(cards.getCardId());
		return true;
	}
	
	

}
