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

	@Column
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long restaurantId;

	@Column
	private String address;

	@Column
	private Time serviceStartTime;

	@Column
	private Time serviceEndTime;

	@Column
	private boolean isServing;

	@Column
	// Current wait time in minutes
	private int waitingPeriod;

	@Column
	private String foodType;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantId")
	private List<MenuItems> menuList;
}
