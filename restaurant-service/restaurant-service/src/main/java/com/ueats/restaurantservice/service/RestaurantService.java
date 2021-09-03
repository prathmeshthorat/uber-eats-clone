package com.ueats.restaurantservice.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ueats.restaurantservice.data.GetOrderPriceReq;
import com.ueats.restaurantservice.entity.Restaurant;
import com.ueats.restaurantservice.repository.MenuItemsRepository;
import com.ueats.restaurantservice.repository.RestaurantRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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

	public double calculateOrderPrice(GetOrderPriceReq orderPriceReq) {
		double sum = 0;
		try {
			Map<Long, Integer> orderMap = orderPriceReq.getItemQuantity();
			SortedMap<Long, Integer> sortedMap = new TreeMap<Long, Integer>(orderMap);
			List<Object> menuIds = Arrays.asList(sortedMap.keySet().toArray());
			
			log.info("Fetching prices for: "+menuIds);
			
			List<Double> priceList = rstRepo.getPriceList(menuIds);
			
			log.info("Fetched prices : "+priceList.toString());
			Iterator<Long> it = sortedMap.keySet().iterator();
			//To:Do price calculation
			for(int i=0; i<priceList.size()-1; i++) {
				log.info("Fetched prices :"+ it.next());
				sum += priceList.get(i) * orderMap.get(it.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		log.info("Calculated price for Order: "+sum);
		return sum;
	}

}
