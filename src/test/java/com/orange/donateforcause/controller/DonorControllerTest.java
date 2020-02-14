package com.orange.donateforcause.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.orange.donateforcause.donor.DonorResponseDto;
import com.orange.donateforcause.dto.PaymentRequestDto;
import com.orange.donateforcause.dto.PaymentResponseDto;
import com.orange.donateforcause.entity.DonationSchemes;
import com.orange.donateforcause.entity.PaymentDetails;
import com.orange.donateforcause.repository.DonorRepository;
import com.orange.donateforcause.repository.PaymentRepository;
import com.orange.donateforcause.service.DonorService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DonorControllerTest {

	@InjectMocks
	DonorController donorController;

	@Mock
	DonorService donorService;
	
	
	
	@Test
	public void testGetAllSchemes() {
		
		List<DonationSchemes> donateSchemes=new ArrayList<>();
		DonationSchemes donationSchemes=new DonationSchemes();
		donationSchemes.setDonationSchemeId(1L);
		donateSchemes.add(donationSchemes);
		DonorResponseDto donorResponseDto=new DonorResponseDto();
		donorResponseDto.setStatusCode(200);
		donorResponseDto.setListOfSchemes(donateSchemes);
		Mockito.when(donorService.getAllSchemes()).thenReturn(donorResponseDto);
		ResponseEntity<DonorResponseDto> allSchemes = donorController.getAllSchemes();
		assertEquals(200,allSchemes.getBody().getStatusCode());
	}
	@Test
	public void testPaymentDetails() {
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setDonationSchemeId(1L);
		paymentDetails.setDonorName("Rajesh");
		paymentDetails.setEmail("rajesh@gmail.com");
		paymentDetails.setPanCard("BDJP1653");
		paymentDetails.setDonationDate(LocalDateTime.now().toString());
		paymentDetails.setCardNo("345678L");
		paymentDetails.setCardType("master");
		paymentDetails.setTaxBenefitAMount("100");
		PaymentRequestDto paymentRequestDto=new PaymentRequestDto();
		paymentRequestDto.setDonationSchemeId(1L);
		PaymentResponseDto paymentResponseDto=new PaymentResponseDto();
		paymentResponseDto.setStatusCode(200);
		Mockito.when(donorService.paymentDetails(paymentRequestDto)).thenReturn(paymentResponseDto);
		ResponseEntity<PaymentResponseDto> paymentDetails2 = donorController.paymentDetails(paymentRequestDto);
		assertEquals(200, paymentDetails2.getBody().getStatusCode());
	}

}
