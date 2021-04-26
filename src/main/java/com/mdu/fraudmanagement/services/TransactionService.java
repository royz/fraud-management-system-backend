package com.mdu.fraudmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdu.fraudmanagement.entities.Card;
import com.mdu.fraudmanagement.entities.Transaction;
import com.mdu.fraudmanagement.entities.User;
import com.mdu.fraudmanagement.repos.TransactionRepository;
import com.mdu.fraudmanagement.repos.UserRepository;

@Service
@Transactional
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	UserRepository userRepository;

	// Register new transaction with user_id from user using mapping
	public void register(Transaction transaction, String user_id) {

		User user = userRepository.findByUserId(user_id);

		if (user != null) {
			transaction.setUser(user);
			transactionRepository.save(transaction);
		}

	}

	// we can pass only id to delete the fraud transaction
	public void deleteTransaction(Transaction transaction) {
		transactionRepository.delete(transaction);
	}

	// Show all Transactions
	public List<Transaction> findAllTransactions() {
		return transactionRepository.findAll();
	}

	// Show Transaction by userId
	public List<Transaction> findTransaction(String user_id) {
		return transactionRepository.findByUserId(user_id);
	}

	// show transaction by fraudLevel
	public List<Transaction> getFraudLevelTransaction(int fraudLevel) {
		return transactionRepository.findByFraudLevel(fraudLevel);
	}

	// edit card fraud by card fraud Id(@param id , Body-
	// acc_no,cardHolderName,cardNo,cardType,
	// dateTime,expiryDate,fraudLevel,islocked)
	public void editFrauds(int id, Transaction transaction) {

		Transaction transactionToUpadate = transactionRepository.getOne(id);

		if (transactionToUpadate != null) {

			transactionToUpadate.setAccNo(transaction.getAccNo());
			transactionToUpadate.setFraudLevel(transaction.getFraudLevel());

			transactionRepository.save(transactionToUpadate);
		}

	}

	// change is blocked status by accNo
	public void changeBlockSattus(String accNo, boolean isLocked) {

		transactionRepository.updateBlockedStatus(accNo, isLocked);
	}

}
