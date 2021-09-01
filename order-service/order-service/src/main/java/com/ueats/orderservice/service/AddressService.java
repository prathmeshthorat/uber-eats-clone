package com.ueats.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.orderservice.entity.Address;
import com.ueats.orderservice.entity.UserEntity;
import com.ueats.orderservice.repository.AddressRepository;
import com.ueats.orderservice.repository.UserRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Address> add(UserEntity user) {
		UserEntity userEntity = userRepo.findById(user.getUserId()).get();
		List<Address> addrList = userEntity.getAddressList();
		addrList.addAll(user.getAddressList());
		userEntity.setAddressList(addrList);
		userRepo.save(userEntity);
		return addrList;
	}
	
	public boolean delete(Address address) {
		addressRepo.delete(address);
		return true;
	}

	public List<Address> getAddressByuserId(long userId) {
		return addressRepo.findByUser(userId);
	}

}
