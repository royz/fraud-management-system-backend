package com.mdu.fraudmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdu.fraudmanagement.entities.Card;
import com.mdu.fraudmanagement.entities.User;
import com.mdu.fraudmanagement.repos.CardRepository;
import com.mdu.fraudmanagement.repos.UserRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;

	@Autowired
	UserRepository userRepository;

	// registar new card (Card obj , user_id) 
	//* Dont send the isBlocked status from the front end
	public void register(Card card, String user_id) {

		User user = userRepository.findByUserId(user_id);

		card.setUser(user);

		cardRepository.save(card);

	}
	
	//show all card
	public List<Card> getAllCard() {
		return cardRepository.findAll();
	}
	
	
	//get card by id
	public Optional<Card> findCard(int id) {
		return cardRepository.findById(id);
	}

	
	
	
	//we can pass only id to delete the fraud
	public void deleteCard(Card card) {

		cardRepository.delete(card);
	}

	

	// find all fraud by fraud level(1-10)
	public List<Card> getByfraudLevel(int fraudLevel) {
		return cardRepository.findByFraudLevel(fraudLevel);
	}

}
