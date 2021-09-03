package com.ueats.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.paymentservice.entity.OrderPayment;
import com.ueats.paymentservice.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class PaymentController {

	@Autowired
	PaymentService payService;

	@PostMapping("/create")
	public OrderPayment createPayRecord(@RequestBody OrderPayment payment) {
		log.info("Create Order Payment request: "+ payment.toString());
		return payService.create(payment);
	}

	@PostMapping("/payorder/{id}")
	public boolean payForOrder(@PathVariable("id") long id) {
		return payService.pay(id);
	}
	
	@GetMapping("/status/{id}")
	public OrderPayment getPaymentStatus(@PathVariable("id") long id) {
		return payService.get(id);
	}
	
	public double calculateOrderPrice() {
		//TO DO: implementation
		return 0;		
	}

}
