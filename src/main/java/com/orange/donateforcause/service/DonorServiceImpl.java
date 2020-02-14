package com.orange.donateforcause.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.orange.donateforcause.donor.DonorResponseDto;
import com.orange.donateforcause.dto.PaymentRequestDto;
import com.orange.donateforcause.dto.PaymentResponseDto;
import com.orange.donateforcause.entity.DonationSchemes;
import com.orange.donateforcause.entity.PaymentDetails;
import com.orange.donateforcause.repository.DonorRepository;
import com.orange.donateforcause.repository.PaymentRepository;
import com.orange.donateforcause.util.DonateUtil;
/**
 *   This class used to provide the all schemes with details
*/
@Service
public class DonorServiceImpl implements DonorService {
	@Autowired
	DonorRepository donorRepository;

	@Autowired
	PaymentRepository paymentRepository;
	@Override
	public DonorResponseDto getAllSchemes() {
		DonorResponseDto donorResponseDto=new DonorResponseDto();
		List<DonationSchemes> schemesResp = donorRepository.findAll();
		donorResponseDto.setMessage(DonateUtil.SUCCESS);
		donorResponseDto.setStatusCode(HttpStatus.OK.value());
		donorResponseDto.setListOfSchemes(schemesResp);
		return donorResponseDto;
	}

	@Override
	public PaymentResponseDto paymentDetails(PaymentRequestDto paymentRequestDto) {
		PaymentResponseDto paymentResponseDto=new PaymentResponseDto();
		
		PaymentDetails paymentDetails=new PaymentDetails();
		paymentDetails.setDonationSchemeId(paymentRequestDto.getDonationSchemeId());
		
		paymentDetails.setDonorName(paymentRequestDto.getDonorName());
		paymentDetails.setEmail(paymentRequestDto.getDonarEmail());
		paymentDetails.setPanCard(paymentRequestDto.getDonarEmail());
		paymentDetails.setDonationDate(LocalDateTime.now().toString());
		paymentDetails.setCardNo(paymentRequestDto.getCardNo());
		paymentDetails.setCardType(paymentRequestDto.getCardType());
		paymentDetails.setTaxBenefitAMount(paymentRequestDto.getTaxBenefitAmount());
		paymentRepository.save(paymentDetails);
		
		paymentResponseDto.setMessage(DonateUtil.SUCCESS);
		paymentResponseDto.setStatusCode(HttpStatus.OK.value());
		paymentResponseDto.setPaymentDetailsId(paymentDetails.getPaymentDetailsId());
		return paymentResponseDto;
	}
}
