package com.orange.donateforcause.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.orange.donateforcause.constant.DonateConstant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto implements Serializable{
	private static final long serialVersionUID = 1L;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private Long mobile;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private String password;
}