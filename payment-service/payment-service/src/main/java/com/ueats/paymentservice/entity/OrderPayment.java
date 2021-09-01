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
	private long correlationId; 
	
	@Column
	private boolean isPaid;
	
	@Column
	private String paymentMethod;
	
	@Column
	private Timestamp createTime;
	
	@Column
	private Timestamp paidTime;
	
	@Column
	private Double amount;

}
