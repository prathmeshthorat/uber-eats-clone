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
	private long correlationId;
	
	@Column
	private long userId;
	
	@Column
	private long addressId;
	
	@Column
	private Timestamp orderTime;	

	@Column
	private long restaurantId;
	
	@Column
	private String status;
	
	@Column
	private boolean isPaid;

}