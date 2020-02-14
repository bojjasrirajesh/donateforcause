package com.orange.donateforcause.service;

import com.orange.donateforcause.donor.DonorResponseDto;
import com.orange.donateforcause.dto.PaymentDetailsResponseDto;
import com.orange.donateforcause.dto.PaymentRequestDto;
import com.orange.donateforcause.dto.PaymentResponseDto;


public interface DonorService {
	
	DonorResponseDto getAllSchemes();
	PaymentResponseDto paymentDetails(PaymentRequestDto paymentRequestDto);
	public  PaymentDetailsResponseDto getPaymentDetails();
	
}
