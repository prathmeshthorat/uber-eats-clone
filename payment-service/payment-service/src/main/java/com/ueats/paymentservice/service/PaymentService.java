package com.ueats.paymentservice.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ueats.paymentservice.constants.OrderPaymentConstants;
import com.ueats.paymentservice.entity.OrderPayment;
import com.ueats.paymentservice.events.entity.OrderEventsEntity;
import com.ueats.paymentservice.events.repository.OrderEventsRepository;
import com.ueats.paymentservice.repository.OrderPaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

	@Autowired
	OrderPaymentRepository orderPayRepo;

	@Autowired
	OrderEventsRepository eventsRepo;

	public OrderPayment create(OrderPayment payment) {

		payment.setCreateTime(Timestamp.from(Instant.now()));
		log.info(" PaymentService Create Order Payment request: " + payment.toString());
		return orderPayRepo.save(payment);
	}

	@Transactional
	public boolean pay(long id) {
		int rowCount = orderPayRepo.setIsPaid(id);

		OrderEventsEntity orderEvent = eventsRepo.findById(id).get();
		orderEvent.setOwnerApp(OrderPaymentConstants.orderEventOwnerAppRestaurant);
		orderEvent.setPaid(true);
		orderEvent.setStatus(OrderPaymentConstants.orderEventStatusPaid);
		eventsRepo.saveAndFlush(orderEvent);

		if (rowCount >= 1)
			return true;
		else
			return false;
	}

	public OrderPayment get(long id) {
		return orderPayRepo.findById(id).get();
	}

}
