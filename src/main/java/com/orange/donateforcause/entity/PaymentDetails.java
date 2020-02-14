package com.orange.donateforcause.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "paymentdetails")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentDetailsId;
	private Long donationSchemeId;
	private String name;
	private Double amount;
	private String currency;
	private String taxBenefitAMount;
	private String email;
	private String panCard;
	private String cardNo;
	private String cardType;
	private String description;
}
