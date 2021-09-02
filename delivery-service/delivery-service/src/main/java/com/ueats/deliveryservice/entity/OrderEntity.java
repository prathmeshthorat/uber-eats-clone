package com.ueats.deliveryservice.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "correlation_id")
	private long correlationId;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "address_id")
	private long addressId;
	
	@Column(name = "order_time")
	private Timestamp orderTime;	

	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "is_paid")
	private boolean isPaid;

}