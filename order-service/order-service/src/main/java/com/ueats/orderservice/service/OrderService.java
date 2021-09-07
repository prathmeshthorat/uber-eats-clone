package com.ueats.orderservice.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.orderservice.data.OrderServiceConstants;
import com.ueats.orderservice.entity.OrderEntity;
import com.ueats.orderservice.entity.OrderItems;
import com.ueats.orderservice.events.entity.OrderEventsEntity;
import com.ueats.orderservice.events.repository.OrderEventsRepository;
import com.ueats.orderservice.repository.OrderItemsRepository;
import com.ueats.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderEventsRepository eventsRepo;
	
	@Autowired
	OrderItemsRepository itemRepo;
	

	public OrderEntity getOrderById(long id) {
		return orderRepo.findById(id).get();
	}

	public List<OrderEntity> getPastOrders(long userId) {
		
		return orderRepo.findByUserId(userId);
	}
	
	@Transactional
	public OrderEntity createOrder(OrderEntity order) {
		Timestamp now = Timestamp.from(Instant.now());
		order.setOrderTime(now);
		order.setStatus(OrderServiceConstants.orderStatusCreated);
		order.setPaid(false);
		List<OrderItems> itemList = order.getItemsList();
		order.setItemsList(new ArrayList<OrderItems>());
		OrderEntity newOrder = orderRepo.save(order);
		for(OrderItems i: itemList) {
			i.setCorrelationId(newOrder.getCorrelationId());
		}
		List<OrderItems> persistedItems = itemRepo.saveAll(itemList);
		newOrder.setItemsList(persistedItems);
		OrderEventsEntity eventEntity = new OrderEventsEntity();
		eventEntity.setCorrelationId(newOrder.getCorrelationId());
		eventEntity.setAddressId(newOrder.getAddressId());
		eventEntity.setUserId(newOrder.getUserId());
		eventEntity.setOrderTime(now);
		eventEntity.setOwnerApp(OrderServiceConstants.ownerAppPayment);
		eventEntity.setPaid(false);
		eventEntity.setRestaurantId(newOrder.getRestaurantId());
		eventEntity.setStatus(OrderServiceConstants.orderStatusCreated);
		
		eventsRepo.save(eventEntity);
		
		return newOrder;
	}
	
	
	
}
