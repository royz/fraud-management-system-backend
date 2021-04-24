package com.mdu.fraudmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mdu.fraudmanagement.entities.Claim;
import com.mdu.fraudmanagement.entities.Transaction;
import com.mdu.fraudmanagement.services.ClaimService;

@RestController
public class ClaimController {

@Autowired
ClaimService claimService;




@PostMapping("/user/claim")
private int registerUser(@RequestBody Claim claims) {

claimService.registerOrUpdateClaim(claims);

		return claims.getId();
}


@PostMapping("/user/frauds/claim/delete") 
	private int addClaim(@RequestBody Claim claims) {
	return claims.getId();
}

@GetMapping("/claim")
List<Claim> getAllClaim() {
	return claimService.getAllClaim();
}
@GetMapping("/claim/{id}")
ResponseEntity<Claim> getById(@PathVariable int id){
	Optional<Claim> cm = claimService.findClaim(id);
	
	return new ResponseEntity<Claim>(HttpStatus.OK);
}




}