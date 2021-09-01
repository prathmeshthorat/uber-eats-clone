package com.ueats.orderservice.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.orderservice.entity.OrderEntity;
import com.ueats.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;

	public OrderEntity getOrderById(long id) {
		return orderRepo.findById(id).get();
	}

	public List<OrderEntity> getPastOrders(long userId) {
		
		return orderRepo.findByUserId(userId);
	}

	public OrderEntity createOrder(OrderEntity order) {
		order.setOrderTime(Timestamp.from(Instant.now()));
		return orderRepo.save(order);
	}
	
	
	
}
