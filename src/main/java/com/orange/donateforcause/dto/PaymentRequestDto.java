package com.orange.donateforcause.dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PaymentRequestDto {
	private Long donationSchemeId;
	private String donorName;
	private String taxBenefitAmount;
	private String 	donarEmail;
	private String panCard;
	private String cardNo;
	private String cardType;
}
