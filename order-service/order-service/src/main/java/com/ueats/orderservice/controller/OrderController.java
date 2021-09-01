package com.ueats.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.orderservice.entity.OrderEntity;
import com.ueats.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/getOrderById/{id}")
	public OrderEntity getOrder(@PathVariable("id") long id) {
		
		OrderEntity order = orderService.getOrderById(id);
		
		return order;
	}
	
	@GetMapping("/history/{userId}")
	public List<OrderEntity> getPastOrders(@PathVariable("userId") long userId){
		return orderService.getPastOrders(userId);		
	}
	
	@PostMapping("/createorder")
	public OrderEntity createOrder(@RequestBody OrderEntity order) {
		return orderService.createOrder(order);
	}
}
