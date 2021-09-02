package com.ueats.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.orderservice.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Query(value = "SELECT * FROM ORDERS A WHERE A.USER_ID=?1", nativeQuery = true)
	List<OrderEntity> findByUserId(long userId);

}
