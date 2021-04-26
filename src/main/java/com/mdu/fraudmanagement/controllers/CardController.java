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
import org.springframework.web.bind.annotation.PutMapping;
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
	//delete by fraud id
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
	
	// get card by user_id
		@GetMapping("/user/one/card/{user_id}")
		ResponseEntity<List<Card>> getByUserId(@PathVariable String user_id) {

			return new ResponseEntity<>(cardService.findCard(user_id), HttpStatus.OK);
		}

	//get card by  cardFraud_id
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
	//edit card fraud by card farud Id(@param id , Body- acc_no,cardHolderName,cardNo,cardType,dateTime,expiryDate,fraudLevel,isblocked)

	@PutMapping("user/fraud/card/update")
	private ResponseEntity<?> editCardFraudById(@RequestParam(name = "id") int id, 
			@RequestBody Card card) {

		cardService.editFrauds(id, card);

		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	
	
	//cahange isblocked status by accNo
	
	@PutMapping("user/fraud/card/blockStatusChange")
	private ResponseEntity<?> editIsBlockedStatusByAccNo(@RequestParam(name = "accNo") String accNo ,
			@RequestParam(name = "isBlocked") boolean isBlocked) {

		cardService.changeBlockSattus(accNo, isBlocked);

		return new ResponseEntity<>(HttpStatus.OK);

	}
	
}









