package com.orange.donateforcause.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private String messgage;
	private int statusCode;
	private LocalDateTime dateAndTime;
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(String messgage, int statusCode, LocalDateTime dateAndTime) {
		super();
		this.messgage = messgage;
		this.statusCode = statusCode;
		this.dateAndTime = dateAndTime;
	}
	public String getMessgage() {
		return messgage;
	}
	public void setMessgage(String messgage) {
		this.messgage = messgage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	
	
	
	
	

}
