package com.mdu.fraudmanagement.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mdu.fraudmanagement.entities.Claim;



public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
