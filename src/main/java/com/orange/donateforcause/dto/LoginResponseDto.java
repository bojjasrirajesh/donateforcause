package com.orange.donateforcause.dto;

import java.io.Serializable;

public class LoginResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private Long doctorId;


	

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}


}
