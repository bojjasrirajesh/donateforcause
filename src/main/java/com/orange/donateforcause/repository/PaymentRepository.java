package com.orange.donateforcause.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orange.donateforcause.entity.PaymentDetails;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails, Long>{
	
	@Query(value="select d.donation_scheme_id,d.schem_name,sum(d.donation_amount) from payment_details p, donation_schemes d where p.donation_scheme_id=d.donation_scheme_id group by d.donation_scheme_id",nativeQuery=true)
	public List<Object[]> getPaymentDetail();

}
