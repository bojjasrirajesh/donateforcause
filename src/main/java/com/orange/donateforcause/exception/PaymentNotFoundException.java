package com.orange.donateforcause.exception;

public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final String message;

	public PaymentNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
