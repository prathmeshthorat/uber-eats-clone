package com.ueats.orderservice.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.orderservice.entity.UserEntity;
import com.ueats.orderservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserService {

	@Autowired
	UserRepository userRepo;

	public UserEntity registerUser(UserEntity user) {
		user.setJoiningDate(Timestamp.from(Instant.now()));
		return userRepo.save(user);
	}

	public UserEntity modifyUser(UserEntity user) {
		return userRepo.save(user);
	}

	public UserEntity getUser(long id) {
		
		return userRepo.findById(id).get();
	}
	
	
	
}
