package com.ueats.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.orderservice.entity.UserEntity;
import com.ueats.orderservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public UserEntity registerUser(@RequestBody UserEntity user) {
		
		return userService.registerUser(user);
	}
	
	@PutMapping("/update")
	public UserEntity modifyUser(@RequestBody UserEntity user) {
		return userService.modifyUser(user);
	}
	
	
	@GetMapping("/getuser/{id}")
	public UserEntity modifyUser(@PathVariable("id") long id) {
		return userService.getUser(id);
	}
}
