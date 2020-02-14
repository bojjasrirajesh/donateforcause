package com.orange.donateforcause.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponseDto {
	private String message;
	private Integer statusCode;
	private Long paymentDetailsId;
}
