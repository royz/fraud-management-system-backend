package com.mdu.fraudmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mdu.fraudmanagement.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//	public List<Transaction> getTransactions();
//	public Transaction getTransaction(long Id);
//	public void deleteTransaction(long Id);
//	public Transaction addTransaction(Transaction transaction);
}
