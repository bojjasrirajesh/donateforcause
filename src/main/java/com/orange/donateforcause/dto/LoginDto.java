package com.orange.donateforcause.dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long mobile;
	private String password;

	
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}