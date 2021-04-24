package com.mdu.fraudmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdu.fraudmanagement.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {


	List<Card> findByFraudLevel(int fraudLevel);



}
