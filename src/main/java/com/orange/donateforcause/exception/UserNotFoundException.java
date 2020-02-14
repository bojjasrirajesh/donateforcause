package com.orange.donateforcause.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final String message;
	
	public UserNotFoundException(String message) {
		super(message);
		this.message=message;
	}
}
