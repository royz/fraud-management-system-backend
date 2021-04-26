package com.mdu.fraudmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdu.fraudmanagement.entities.Transaction;
import com.mdu.fraudmanagement.services.TransactionService;

@RestController
public class TransactionsController {
	@Autowired
	TransactionService transactionService;

	// register new Transaction (Transaction obj , user_id)
	// * Don't send the isBlocked status from the front end
	@PostMapping("/user/frauds/transaction/add")
	private ResponseEntity<Integer> registerTransaction(@RequestBody Transaction transaction,
			@RequestParam String user_id) {
		transactionService.register(transaction, user_id);
		return new ResponseEntity<>(transaction.getId(), HttpStatus.ACCEPTED);
	}

	// we can pass only id to delete the fraud
	@DeleteMapping("/user/frauds/transaction/delete")
	private int deleteTransaction(@RequestBody Transaction transaction) {
		transactionService.deleteTransaction(transaction);
		return transaction.getId();
	}

	// Show Transaction by user_id
	@GetMapping("/user/one/transaction/{user_id}")
	private ResponseEntity<List<Transaction>> findByUserId(@PathVariable String user_id) {
		return new ResponseEntity<>(transactionService.findTransaction(user_id), HttpStatus.OK);
	}

	// Show all Transaction
	@GetMapping("/user/all/transaction")
	private List<Transaction> findAllTransactions(@RequestBody Transaction transaction) {
		return transactionService.findAllTransactions();
	}

	// find all frauds by fraud level(1-10)
	@GetMapping("/user/fraud/transaction/{fraudLevel}")
	public ResponseEntity<List<Transaction>> getAllCardFraudByFraudLevel(@PathVariable int fraudLevel) {

		if (!transactionService.getFraudLevelTransaction(fraudLevel).isEmpty()) {

			return new ResponseEntity<>(transactionService.getFraudLevelTransaction(fraudLevel), HttpStatus.OK);
		} else
			return new ResponseEntity<>(transactionService.getFraudLevelTransaction(fraudLevel), HttpStatus.NO_CONTENT);

	}

	// edit transaction fraud by transaction fraud Id
	@PutMapping("/user/fraud/transaction/update")
	private ResponseEntity<?> editTransactionFraudById(@RequestParam(name = "id") int id,
			@RequestBody Transaction transaction) {

		transactionService.editFrauds(id, transaction);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	// change is blocked status by accNo
	@PutMapping("user/fraud/transaction/blockStatusChange")
	private ResponseEntity<?> editIsBlockedStatusByAccNo(@RequestParam(name = "accNo") String accNo,
			@RequestParam(name = "isLocked") boolean isLocked) {

		transactionService.changeBlockSattus(accNo, isLocked);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
