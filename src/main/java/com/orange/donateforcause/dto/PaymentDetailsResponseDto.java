package com.orange.donateforcause.dto;

import java.util.List;

import com.orange.donateforcause.entity.PaymentDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetailsResponseDto {
	private List<PaymentDetails> paymentDetails;	

}
