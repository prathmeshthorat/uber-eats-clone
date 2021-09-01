package com.ueats.paymentservice.service;

import java.sql.Timestamp;
import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.paymentservice.entity.OrderPayment;
import com.ueats.paymentservice.repository.OrderPaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	OrderPaymentRepository orderPayRepo;

	public OrderPayment create(OrderPayment payment) {
		payment.setCreateTime(Timestamp.from(Instant.now()));
		return orderPayRepo.save(payment);
	}
	
	@Transactional
	public boolean pay(long id) {
		int rowCount = orderPayRepo.setIsPaid(id);
		if(rowCount >= 1)
			return true;
		else 
			return false;
	}

	public OrderPayment get(long id) {
		return orderPayRepo.findById(id).get();
	}
	
	
}
