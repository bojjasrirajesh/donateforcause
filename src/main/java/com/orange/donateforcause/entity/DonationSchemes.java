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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "donationschemes")
public class DonationSchemes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long donationSchemeId;
	private String name;
	private Double taxBenefitPer;
}
