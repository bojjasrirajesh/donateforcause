package com.orange.donateforcause.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.donateforcause.donor.DonorResponseDto;
import com.orange.donateforcause.dto.PaymentRequestDto;
import com.orange.donateforcause.dto.PaymentResponseDto;
import com.orange.donateforcause.service.DonorService;
import com.orange.donateforcause.util.DonateUtil;

/**
 * @author Rajesh
 * 
 *         This class is used for to donate the amount to the login function. if
 *         success it will return success else it will return user invalid
 * 
 */
@RestController
@RequestMapping("/donations")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class DonorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DonorController.class);

	@Autowired
	DonorService donorService;

	/**
	 * API to get all donation scheme information.
	 * @return	send success code.
	 */
	@GetMapping("/schemes")
	public ResponseEntity<DonorResponseDto> getAllSchemes() {
		LOGGER.debug(DonateUtil.SCHEMES);
		DonorResponseDto donorResponseDto = donorService.getAllSchemes();
		return new ResponseEntity<>(donorResponseDto, HttpStatus.OK);
	}

	/**
	 * API to complete user payment.
	 * 
	 * @param paymentRequestDto
	 * @return	send success code.
	 */
	@PostMapping(value = "/paymentDetails")
	public ResponseEntity<PaymentResponseDto> paymentDetails(@RequestBody PaymentRequestDto paymentRequestDto) {
		LOGGER.debug(DonateUtil.PAYMNET);
		PaymentResponseDto paymentResponseDto = donorService.paymentDetails(paymentRequestDto);
		return new ResponseEntity<>(paymentResponseDto, HttpStatus.OK);
	}
}