package com.mdu.fraudmanagement.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClaimNotFoundException extends RuntimeException {
	private String message;

	public ClaimNotFoundException(String message) {
         this.message = message;
     }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}