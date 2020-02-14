package com.orange.donateforcause.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.orange.donateforcause.donor.DonorResponseDto;
import com.orange.donateforcause.dto.PaymentDataDto;
import com.orange.donateforcause.dto.PaymentDetailsResponseDto;
import com.orange.donateforcause.dto.PaymentRequestDto;
import com.orange.donateforcause.dto.PaymentResponseDto;
import com.orange.donateforcause.entity.DonationSchemes;
import com.orange.donateforcause.entity.PaymentDetails;
import com.orange.donateforcause.exception.PaymentNotFoundException;
import com.orange.donateforcause.repository.DonorRepository;
import com.orange.donateforcause.repository.PaymentRepository;
import com.orange.donateforcause.util.DonateUtil;

/**
 * This class used to provide the all schemes with details
 */
@Service
public class DonorServiceImpl implements DonorService {
	@Autowired
	DonorRepository donorRepository;

	@Autowired
	PaymentRepository paymentRepository;

	/**
	 * Method to get all donation schemes.
	 */
	@Override
	public DonorResponseDto getAllSchemes() {
		DonorResponseDto donorResponseDto = new DonorResponseDto();
		List<DonationSchemes> schemesResp = donorRepository.findAll();
		donorResponseDto.setMessage(DonateUtil.SUCCESS);
		donorResponseDto.setStatusCode(HttpStatus.OK.value());
		donorResponseDto.setListOfSchemes(schemesResp);
		return donorResponseDto;
	}

	/**
	 * Method to confirm and persist payment information.
	 */
	@Override
	public PaymentResponseDto paymentDetails(PaymentRequestDto paymentRequestDto) {
		PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
		PaymentDetails paymentDetails = new PaymentDetails();
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

	/**
	 * Method used to view all payment details
	 */
	@Override
	public PaymentDetailsResponseDto getPaymentDetails() {
		List<Object[]> objects = paymentRepository.getPaymentDetail();
		List<PaymentDataDto> paymentDataDtos = new ArrayList<PaymentDataDto>();
		if (!Objects.isNull(objects)) {
			for (Object object[] : objects) {
				PaymentDataDto paymentDataDto = new PaymentDataDto();
				paymentDataDto.setDonationSchemaId(Long.parseLong(object[0].toString()));
				paymentDataDto.setName(object[1].toString());
				paymentDataDto.setAmount(Double.parseDouble(object[2].toString()));
				paymentDataDtos.add(paymentDataDto);
			}
		} else {
			throw new PaymentNotFoundException(DonateUtil.NO_PAYMENT);
		}
		PaymentDetailsResponseDto paymentDetailsResponseDto = new PaymentDetailsResponseDto();
		paymentDetailsResponseDto.setPaymentDetails(paymentDataDtos);
		return paymentDetailsResponseDto;
	}
}
