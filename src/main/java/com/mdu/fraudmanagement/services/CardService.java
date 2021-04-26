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
		
		if(user!=null) {
			card.setUser(user);
			cardRepository.save(card);
		}
		
		

		

	}
	
	//show all card
	public List<Card> getAllCard() {
		return cardRepository.findAll();
	}
	
	// show card details of user_id
		public List<Card> findCard(String user_id) {

			return cardRepository.findByUserId(user_id);
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

	
	//edit card fraud by card farud Id(@param id , Body- acc_no,cardHolderName,cardNo,cardType,
	//dateTime,expiryDate,fraudLevel,isblocked)
	public void editFrauds(int id, Card card) {
		
		Card cardToUpadate=cardRepository.getOne(id);
		
		
		
			if(cardToUpadate!=null) {
				
				
				cardToUpadate.setAccNo(card.getAccNo());
				cardToUpadate.setCardHolderName(card.getCardHolderName());
				cardToUpadate.setCardNo(card.getCardNo());
				cardToUpadate.setCardType(card.getCardType());
				cardToUpadate.setdateTime(card.getdateTime());
				cardToUpadate.setExpiryDate(card.getExpiryDate());
				cardToUpadate.setFraudLevel(card.getFraudLevel());
				
				cardRepository.save(cardToUpadate);
			}
		
		}
	//cahange is blocked status by accNo
	public void changeBlockSattus(String accNo, boolean isBlocked) {
		
		cardRepository.updateBlockedStatus(accNo,isBlocked);
	}
	



}
