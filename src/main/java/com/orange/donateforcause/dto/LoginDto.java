package com.orange.donateforcause.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long mobile;
	private String password;
}