package com.ueats.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.paymentservice.entity.OrderPayment;

@Repository
public interface OrderPaymentRepository extends JpaRepository<OrderPayment, Long>{
	
	@Modifying
	@Query(value = "UPDATE ORDER_PAYMENT SET IS_PAID=TRUE, PAID_TIME= NOW() WHERE CORRELATION_ID=?1", nativeQuery = true)
	public int setIsPaid(long id);

}
