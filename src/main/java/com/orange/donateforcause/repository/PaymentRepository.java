package com.orange.donateforcause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.donateforcause.entity.PaymentDetails;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails, Long>{

}
