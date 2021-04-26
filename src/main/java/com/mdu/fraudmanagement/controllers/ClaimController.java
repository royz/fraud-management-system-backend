package com.mdu.fraudmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdu.fraudmanagement.entities.Claim;
import com.mdu.fraudmanagement.services.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	ClaimService claimService;

	// register new Claim (Claim obj , user_id)
	@PostMapping("/user/frauds/claim/add")
	private ResponseEntity<Integer> registerCard(@RequestBody Claim claim, @RequestParam String user_id) {

		claimService.register(claim, user_id);

		return new ResponseEntity<>(claim.getId(), HttpStatus.ACCEPTED);

	}

	// delete by fraud id
	// we can pass only id to delete the fraud
	@PostMapping("/user/frauds/claim/delete")
	private int addClaim(@RequestBody Claim claims) {
		return claims.getId();
	}

	// List all claimFrauds
	@GetMapping("/user/all/claim")
	List<Claim> getAllClaim() {

		return claimService.getAllClaim();
	}

	// List fraud by user_id
	@GetMapping("/user/one/claim/{user_id}")
	ResponseEntity<List<Claim>> getByUserId(@PathVariable String user_id) {

		return new ResponseEntity<>(claimService.findClaim(user_id), HttpStatus.OK);
	}

// Edit the Claim based on id
	@PutMapping("/user/fraud/claim/update")
	private ResponseEntity<?> editClaimFraudById(@RequestParam(name = "id") int id, @RequestBody Claim claim) {

		claimService.editFrauds(id, claim);

		return new ResponseEntity<>(HttpStatus.OK);

	}
	// change isDuplicate status by idProofNo
	@PutMapping("/user/fraud/claim/duplicacycheck")
	private ResponseEntity<?> editIsDuplicateStatusByIdProofNo(@RequestParam(name = "idProofNo") int idProofNo,
			@RequestParam(name = "isDuplicate") boolean isDuplicate) {

		claimService.changeDuplicateStatus(idProofNo, isDuplicate);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}