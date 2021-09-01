package com.ueats.deliveryservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.deliveryservice.repository.OrderRepository;

@Service
public class DeliveryService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Transactional
	public boolean setOrderStatus(long correlationId) {
		return orderRepo.setStatus(correlationId) >=1 ? true: false;
	}
}
