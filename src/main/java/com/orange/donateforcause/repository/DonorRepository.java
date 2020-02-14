package com.orange.donateforcause.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.donateforcause.entity.DonationSchemes;

public interface DonorRepository extends JpaRepository<DonationSchemes, Long> {

}
