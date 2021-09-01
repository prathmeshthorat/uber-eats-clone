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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -360785715173374253L;

	
	@Column
	private long restaurantId;
	
	@Id
	private long menuId;
	
	@Column
	private String instructions;
	
	@Column
	private int quantity;
}
