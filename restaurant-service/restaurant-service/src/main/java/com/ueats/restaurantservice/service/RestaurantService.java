package com.ueats.restaurantservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.restaurantservice.entity.Restaurant;
import com.ueats.restaurantservice.repository.MenuItemsRepository;
import com.ueats.restaurantservice.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository rstRepo;

	@Autowired
	MenuItemsRepository menuRepo;

	public List<Restaurant> getAll() {
		return rstRepo.findAll();
	}

	public Restaurant createRestaurant(Restaurant restaurant) {
		return rstRepo.save(restaurant);
	}

	public Restaurant addMenu(Restaurant restaurant) {
		Restaurant rst = rstRepo.findById(restaurant.getRestaurantId()).get();
		rst.getMenuList().addAll(restaurant.getMenuList());
		rstRepo.save(rst);
		return rst;
	}

	@Transactional
	public boolean removeMenu(long menuId, int available) {
		int rowCount = menuRepo.updateIsAvailable(menuId, available);
		return rowCount >= 1 ? true : false;
	}

	public Restaurant getRestaurant(long id) {
		
		return rstRepo.findById(id).get();
	}

}
