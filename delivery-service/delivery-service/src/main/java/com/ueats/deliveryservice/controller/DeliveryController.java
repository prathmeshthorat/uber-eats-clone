package com.ueats.deliveryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.deliveryservice.service.DeliveryService;

@RestController
@RequestMapping("/")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@PutMapping("/delivered/{id}")
	public boolean setDeliveredStatus(@PathVariable("id") long correlationId) {
		return deliveryService.setOrderStatus(correlationId);
	}
}
