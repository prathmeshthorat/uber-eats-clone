package com.ueats.orderservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "items")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OrderItems.class)
public class OrderItems implements Serializable {
	
	private static final long serialVersionUID = -360785715173374253L;
	
	@Id
	@Column(name = "correlation_id")
	private long correlationId;
	
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Id
	@Column(name = "menu_id")
	private long menuId;
	
	@Column(name = "instructions")
	private String instructions;
	
	@Column(name = "quantity")
	private int quantity;
}
