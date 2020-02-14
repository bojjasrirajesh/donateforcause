package com.orange.donateforcause.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.donateforcause.entity.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, Long>{

}
