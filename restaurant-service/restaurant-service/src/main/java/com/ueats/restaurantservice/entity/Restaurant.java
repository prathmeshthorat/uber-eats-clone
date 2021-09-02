package com.ueats.restaurantservice.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Column(name = "name")
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restaurant_id")
	private long restaurantId;

	@Column(name = "address")
	private String address;

	@Column(name = "service_start_time")
	private Time serviceStartTime;

	@Column(name = "service_end_time")
	private Time serviceEndTime;

	@Column(name = "is_serving")
	private boolean isServing;

	@Column(name = "waiting_period")
	// Current wait time in minutes
	private int waitingPeriod;

	@Column(name = "food_type")
	private String foodType;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private List<MenuItems> menuList;
}
