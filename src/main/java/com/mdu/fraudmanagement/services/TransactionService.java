package com.mdu.fraudmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdu.fraudmanagement.entities.Transaction;
import com.mdu.fraudmanagement.repos.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	public void registerOrUpdateTransaction(Transaction transaction) {

		transactionRepository.save(transaction);

	}
	public void deleteTransaction(Transaction transaction) {

		transactionRepository.delete(transaction);

	}
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}
	public Optional<Transaction> findTransaction(int id) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(id);
	}
	
	
}