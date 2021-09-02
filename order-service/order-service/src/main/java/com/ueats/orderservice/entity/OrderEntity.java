package com.ueats.orderservice.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "correlation_id")
	private List<OrderItems> itemsList;
	
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "is_paid")
	private boolean isPaid;

}
