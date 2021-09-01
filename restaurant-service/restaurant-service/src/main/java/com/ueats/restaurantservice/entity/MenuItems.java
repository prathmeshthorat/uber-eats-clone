package com.ueats.restaurantservice.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_items")
public class MenuItems {

	@Column
	private String dishName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long menuId;

	@Column
	private String dishType;

	@Column
	private boolean isAvailable;

	@Column
	private double price;

	@Column
	private double discount;

}
