package com.exception;

public class InvalidCredentialsException extends Exception{


	private static final long serialVersionUID = 8525511921593335034L;
	private String message; 
	
	public InvalidCredentialsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


	
}