package com.orange.donateforcause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.donateforcause.entity.DonationSchemes;

@Repository
public interface DonorRepository extends JpaRepository<DonationSchemes, Long> {

}
