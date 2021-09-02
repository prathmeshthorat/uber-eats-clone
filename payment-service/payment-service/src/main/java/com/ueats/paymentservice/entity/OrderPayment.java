package com.ueats.paymentservice.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_payment")
public class OrderPayment {
	
	@Id
	@Column(name = "correlation_id")
	private long correlationId; 
	
	@Column(name = "is_paid")
	private boolean isPaid;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "create_time")
	private Timestamp createTime;
	
	@Column(name = "paid_time")
	private Timestamp paidTime;
	
	@Column(name = "amount")
	private Double amount;

}
