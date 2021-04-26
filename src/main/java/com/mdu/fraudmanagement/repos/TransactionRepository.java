package com.mdu.fraudmanagement.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdu.fraudmanagement.entities.Transaction;

@Transactional   // added for update query and also for delete query
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	public List<Transaction> findByFraudLevel(int fraudLevel);

	@Query(value="SELECT * from transaction t WHERE t.user_id=?1 ",nativeQuery = true)
	public List<Transaction> findByUserId(String user_id);

	//public void save(TransactionDto tran);
	
	@Modifying
	@Query(value = "UPDATE transaction t SET t.is_locked=?2  WHERE t.acc_no=?1 ", nativeQuery = true)
	public void updateBlockedStatus(@Param("acc_no") String accNo, @Param("is_locked") boolean isLocked);

}
