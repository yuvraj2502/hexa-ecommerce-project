package com.exception;

public class InvalidLoginInput extends Exception {

	private static final long serialVersionUID = 2475460366414587357L;
	private String message;

	public InvalidLoginInput(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
