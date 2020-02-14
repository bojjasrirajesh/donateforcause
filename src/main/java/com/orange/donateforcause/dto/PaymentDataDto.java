package com.orange.donateforcause.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDataDto {

	private Long donationSchemaId;
	private String name;
    private Double amount;
	
	
}
