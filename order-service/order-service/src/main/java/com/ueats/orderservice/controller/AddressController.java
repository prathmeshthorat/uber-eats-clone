package com.ueats.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.orderservice.entity.Address;
import com.ueats.orderservice.entity.UserEntity;
import com.ueats.orderservice.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/")
	public List<Address> addAddress(@RequestBody UserEntity user) {
		return addressService.add(user);
	}
	
	@DeleteMapping("/")
	public boolean deleteAddress(@RequestBody Address address) {
		return addressService.delete(address);
	}
	
	@GetMapping("/{userid}")
	public List<Address> getAddressById(@PathVariable("userid") long userId){
		return addressService.getAddressByuserId(userId);
	}
	
}
