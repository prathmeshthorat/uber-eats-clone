package com.ueats.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.deliveryservice.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Modifying
	@Query(value= "update OrderEntity set status='DELIVERED' where correlationId=?1")
	public int setStatus(long correlationId);

}
