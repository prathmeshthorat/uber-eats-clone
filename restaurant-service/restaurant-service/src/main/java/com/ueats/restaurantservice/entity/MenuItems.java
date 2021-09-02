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

	@Column(name = "dish_name")
	private String dishName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menu_id")
	private long menuId;

	@Column(name = "dish_type")
	private String dishType;

	@Column(name = "is_available")
	private boolean isAvailable;

	@Column(name = "price")
	private double price;

	@Column(name = "discount")
	private double discount;

}
