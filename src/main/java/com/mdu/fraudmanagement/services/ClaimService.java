package com.mdu.fraudmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdu.fraudmanagement.entities.Card;
import com.mdu.fraudmanagement.entities.Claim;
import com.mdu.fraudmanagement.entities.User;
import com.mdu.fraudmanagement.repos.ClaimRepository;
import com.mdu.fraudmanagement.repos.UserRepository;

@Service
public class ClaimService {

	@Autowired
	ClaimRepository claimRepository;

	@Autowired
	UserRepository userRepository;

//new registration of claim
	public void register(Claim claim, String user_id) {

		User user = userRepository.findByUserId(user_id);

		claim.setUser(user);

		claimRepository.save(claim);

	}

	public void deleteClaim(Claim claims) {

		claimRepository.delete(claims);
	}

	public List<Claim> getAllClaim() {

		return claimRepository.findAll();
	}

	public List<Claim> findClaim(String user_id) {

		return claimRepository.findByUserId(user_id);
	}

	public void editFrauds(int id, Claim claim) {

		Claim claimToUpadate = claimRepository.getOne(id);

		if (claimToUpadate != null) {
			claimToUpadate.setIdProofNo(claim.getIdProofNo());

			claimRepository.save(claimToUpadate);
		}

	}

	public Claim findByIdProofNo(int idProofNo) {

		return claimRepository.findByIdProofNo(idProofNo);
	}

	// cahange is blocked status by idProofNo
	public void changeDuplicateStatus(int idProofNo, boolean isDuplicate) {

		claimRepository.updateDuplicateStatus(idProofNo, isDuplicate);
	}

}