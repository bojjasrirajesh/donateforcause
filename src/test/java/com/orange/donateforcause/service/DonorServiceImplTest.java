package com.orange.donateforcause.service;
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

import com.orange.donateforcause.donor.DonorResponseDto;
import com.orange.donateforcause.entity.DonationSchemes;
import com.orange.donateforcause.entity.PaymentDetails;
import com.orange.donateforcause.repository.DonorRepository;
import com.orange.donateforcause.repository.PaymentRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DonorServiceImplTest {

	@InjectMocks
	DonorServiceImpl donorServiceImpl;

	@Mock
	DonorRepository donorRepository;
	
	@Mock
	PaymentRepository paymentRepository;
	
	@Test
	public void testGetAllSchemes() {
		
		List<DonationSchemes> donateSchemes=new ArrayList<>();
		DonationSchemes donationSchemes=new DonationSchemes();
		donationSchemes.setDonationSchemeId(1L);
		donateSchemes.add(donationSchemes);
		Mockito.when(donorRepository.findAll()).thenReturn(donateSchemes);
		DonorResponseDto allSchemes = donorServiceImpl.getAllSchemes();
		assertEquals(200, allSchemes.getStatusCode());
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
		Mockito.when(paymentRepository.save(paymentDetails)).thenReturn(null);
	}

}
