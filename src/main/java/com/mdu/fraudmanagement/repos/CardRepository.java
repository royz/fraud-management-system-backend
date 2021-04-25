package com.mdu.fraudmanagement.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.mdu.fraudmanagement.entities.Card;
@Transactional //added for update query and also for delete query
@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {


	List<Card> findByFraudLevel(int fraudLevel);
	
//	Card findById(int id);
	@Modifying
	@Query(value="UPDATE cards c SET c.is_blocked=?2  WHERE c.acc_no=?1 ",nativeQuery = true)
	public void updateBlockedStatus(@Param("acc_no") String accNo ,@Param("is_blocked") boolean isBlocked);



}
