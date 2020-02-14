package com.orange.donateforcause.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentDetailsId;
	private Long donationSchemeId;
	private String donorName;
	private String donationDate;
	private String taxBenefitAMount;
	private String email;
	private String panCard;
	private String cardNo;
	private String cardType;
	private Blob donorPdf;
}
