package com.ueats.restaurantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.restaurantservice.entity.MenuItems;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {
	
	@Modifying
	@Query(value = "update menu_items set is_available=?2 where menu_id=?1", nativeQuery = true)
	public int updateIsAvailable(long menuId, int available);

}
