
package com.mdu.fraudmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdu.fraudmanagement.entities.Claim;


import com.mdu.fraudmanagement.repos.ClaimRepository;

@Service
public class ClaimService {

@Autowired
ClaimRepository claimRepository;


//new registration of claim
public void registerOrUpdateClaim(Claim claims) {

claimRepository.save(claims);

}
public void deleteClaim(Claim claims) {
	
	claimRepository.delete(claims);
}
public List<Claim> getAllClaim() {
	// TODO Auto-generated method stub
	return claimRepository.findAll();
}
public Optional<Claim> findClaim(int id) {
	// TODO Auto-generated method stub
	return claimRepository.findById(id);
}
}
