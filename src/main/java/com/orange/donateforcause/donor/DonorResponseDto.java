package com.orange.donateforcause.donor;

import java.io.Serializable;
import java.util.List;

import com.orange.donateforcause.entity.DonationSchemes;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DonorResponseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private List<DonationSchemes> listOfSchemes;
}
