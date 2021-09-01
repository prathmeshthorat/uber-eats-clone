package com.ueats.orderservice.events.entity;

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
	private long correlationId;
	
	@Column
	private long addressId;
	
	@Column
	private String status;
	
	@Column
	private boolean isPaid;
	
	@Column
	private Timestamp orderTime;
	
	@Column
	private Timestamp deliveryTime;
	
	@Column
	private long restaurantId;
	
	@Column
	private long userId;
	
	@Column
	private String ownerApp;
	
}
