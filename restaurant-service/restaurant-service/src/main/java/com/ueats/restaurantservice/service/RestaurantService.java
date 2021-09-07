package com.ueats.restaurantservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
		log.info(orderPriceReq.toString());
		try {
			Map<Long, Integer> orderMap = orderPriceReq.getItemQuantity();
			SortedMap<Long, Integer> sortedMap = new TreeMap<Long, Integer>(orderMap);
			List<Long> menuIds = new ArrayList<Long>(sortedMap.keySet());
			log.info("Fetching prices for: " + menuIds);

			List<Double> priceList = rstRepo.getPriceList(menuIds);
			log.info("Discounted prices : " + priceList);
			for(int n=0; n<priceList.size(); n++) {
				sum += sortedMap.get(menuIds.get(n)) * priceList.get(n);
			}
			
			log.info("Order price : " + sum);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		log.info("Calculated price for Order: " + sum);
		return sum;
	}

}
