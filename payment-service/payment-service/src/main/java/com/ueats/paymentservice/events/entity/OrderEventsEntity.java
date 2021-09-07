package com.ueats.paymentservice.events.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order_events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEventsEntity {
	
	@Id
	@Column(name = "correlation_id")
	private long correlationId;
	
	@Column(name = "address_id")
	private long addressId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "is_paid")
	private boolean isPaid;
	
	@Column(name = "order_time")
	private Timestamp orderTime;
	
	@Column(name = "delivery_time")
	private Timestamp deliveryTime;
	
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "owner_app")
	private String ownerApp;
	
}
