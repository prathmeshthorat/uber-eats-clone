package com.ueats.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ueats.restaurantservice.data.GetOrderPriceReq;
import com.ueats.restaurantservice.entity.Restaurant;
import com.ueats.restaurantservice.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class RestaurantController {
	
	@Autowired
	RestaurantService rstService;
	
	@GetMapping("/all")
	public List<Restaurant> getRestaurantList(){
		return rstService.getAll();
	}
	
	@PostMapping("/add")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return rstService.createRestaurant(restaurant);
	}
	
	@PostMapping("/addmenu")
	public Restaurant addMenuToRestaurant(@RequestBody Restaurant restaurant) {
		return rstService.addMenu(restaurant);
	}
	
	@PutMapping("/removeMenu/{menuId}/{available}")
	public boolean removeMenu(@PathVariable("menuId") long menuId, @PathVariable("available") int available ) {
		return rstService.removeMenu(menuId, available);
	}
	
	@GetMapping("/getrestaurant/{id}")
	public Restaurant getRestaurant(@PathVariable("id") long id) {
		return rstService.getRestaurant(id);
	}
	
	@PostMapping("/calculateorderprice")
	public ResponseEntity<Double> calculateOrderPrice(@RequestBody GetOrderPriceReq orderPriceReq){
		log.info(orderPriceReq.toString());
		double price = rstService.calculateOrderPrice(orderPriceReq);
		
		return new ResponseEntity<Double>(price, HttpStatus.OK);	
	}
	
	
}
