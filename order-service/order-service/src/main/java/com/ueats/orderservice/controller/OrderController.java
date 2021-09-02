package com.ueats.orderservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ueats.orderservice.data.AddPaymentRecordRequest;
import com.ueats.orderservice.data.GetOrderPriceReq;
import com.ueats.orderservice.data.OrderServiceConstants;
import com.ueats.orderservice.entity.OrderEntity;
import com.ueats.orderservice.entity.OrderItems;
import com.ueats.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getOrderById/{id}")
	public OrderEntity getOrder(@PathVariable("id") long id) {

		OrderEntity order = orderService.getOrderById(id);

		return order;
	}

	@GetMapping("/history/{userId}")
	public List<OrderEntity> getPastOrders(@PathVariable("userId") long userId) {
		return orderService.getPastOrders(userId);
	}

	@PostMapping("/createorder")
	public OrderEntity createOrder(@RequestBody OrderEntity order) {
		
		OrderEntity newOrder = orderService.createOrder(order);
		
		GetOrderPriceReq orderPriceReq = new GetOrderPriceReq();
		Map<Long, Integer> contents = new HashMap<Long, Integer>();
		List<OrderItems> itemsList = order.getItemsList();
		for (OrderItems i : itemsList) {
			contents.put(i.getMenuId(), i.getQuantity());
		}
		orderPriceReq.setItemQuantity(contents);
		orderPriceReq.setRestaurantId(order.getRestaurantId());

		ResponseEntity<Double> orderPrice = restTemplate
				.postForEntity("http://localhost:8087/restaurant/calculateorderprice", orderPriceReq, Double.class);
		
		AddPaymentRecordRequest paymentRecordRequest = new AddPaymentRecordRequest();
		paymentRecordRequest.setCorrelationId(newOrder.getCorrelationId());
		paymentRecordRequest.setPaid(false);
		paymentRecordRequest.setAmount(orderPrice.getBody());
		paymentRecordRequest.setPaymentMethod(OrderServiceConstants.paymentRecordMethodOnline);
		
		restTemplate.postForObject("http://localhost:8085/payment/create", 
				paymentRecordRequest, AddPaymentRecordRequest.class);
		
		return newOrder;
	}
}
