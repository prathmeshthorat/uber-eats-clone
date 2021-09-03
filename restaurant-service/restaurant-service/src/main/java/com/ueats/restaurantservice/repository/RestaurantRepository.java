package com.ueats.restaurantservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.restaurantservice.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query(value = "SELECT (PRICE * (100 - DISCOUNT)/100) AS ORDER_PRICE FROM UBER_EATS_RESTAURANT.MENU_ITEMS WHERE MENU_ID IN (9, 10)", nativeQuery = true)
	List<Double> getPriceList(List<Object> menuIds);

}
