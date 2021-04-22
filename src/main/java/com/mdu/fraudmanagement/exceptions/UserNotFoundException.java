package com.mdu.fraudmanagement.exceptions;


	public class UserNotFoundException extends RuntimeException {
		public UserNotFoundException(String message) {
			super(message);
		}
	}
