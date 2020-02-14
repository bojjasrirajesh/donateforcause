package com.orange.donateforcause.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.orange.donateforcause.constant.DonateConstant;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PaymentRequestDto {
	private Long donationSchemeId;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private String donorName;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private String taxBenefitAmount;
	@Email(message=DonateConstant.VALID_EMAIL)
	private String 	donarEmail;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private String panCard;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private String cardNo;
	@NotBlank(message=DonateConstant.BLANK_MESSAGE)
	private String cardType;
}
