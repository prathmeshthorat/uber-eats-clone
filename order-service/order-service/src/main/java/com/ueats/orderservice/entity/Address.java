package com.ueats.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private long addressId;
		
	@Column(name = "first_line")
	private String firstLine;
	
	@Column(name = "second_line")
	private String secondLine;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zipcode")
	private int zipcode;
	
	@Column(name = "address_type")
	private String addressType;
	
	@Column(name = "is_primary")
	private boolean isPrimary;
	
}
