package com.mdu.fraudmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdu.fraudmanagement.entities.Card;
import com.mdu.fraudmanagement.entities.User;
import com.mdu.fraudmanagement.services.CardService;

@RestController
public class CardController {

	@Autowired
	CardService cardService;

	
	//registar new card (Card obj , user_id)
	//* Dont send the isBlocked status from the front end
	@PostMapping("/user/frauds/card/add")
	private ResponseEntity<Integer> registerCard(@RequestBody Card card ,@RequestParam String user_id) {
		
		cardService.register(card,user_id);
		
		return new ResponseEntity<>(card.getId(),HttpStatus.ACCEPTED);

	}
	
	//we can pass only id to delete the fraud
	@DeleteMapping("/user/frauds/card/delete")
	private int deleteCard(@RequestBody Card card) {
		cardService.deleteCard(card);
		return card.getId();
	}
	
	//show all card
	@GetMapping("/user/all/card")
	List<Card> getAllCard() {
		return cardService.getAllCard();
	}

	//get card by id
	@GetMapping("/user/one/card/{id}")
	ResponseEntity<Card> getById(@PathVariable int id) {
		Optional<Card> cd = cardService.findCard(id);
		if (cd.isPresent()) {
			return new ResponseEntity<Card>(cd.get(), HttpStatus.OK);
		}
		return null;
	}
	
	//find all fraud by fraud level(1-10)
	@GetMapping("user/fraud/card/fraudLevel")
	public ResponseEntity<List<Card>> getAllCardFraudByFraudLevel(@RequestParam int fraudLevel) {

		if(!cardService.getByfraudLevel(fraudLevel).isEmpty()) {
			
			return new ResponseEntity<>(cardService.getByfraudLevel(fraudLevel), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(cardService.getByfraudLevel(fraudLevel), HttpStatus.NO_CONTENT);
		
		
	}

}
