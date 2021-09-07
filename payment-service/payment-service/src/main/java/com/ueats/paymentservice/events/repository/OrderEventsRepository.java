package com.ueats.paymentservice.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.paymentservice.events.entity.OrderEventsEntity;

@Repository
public interface OrderEventsRepository extends JpaRepository<OrderEventsEntity, Long> {

	@Modifying
	@Query(value = "UPDATE UBER_EATS_EVENTS.ORDER_EVENTS SET STATUS= ?1, IS_PAID= ?2, OWNER_APP= ?3 WHERE CORRELATION_ID= ?4", nativeQuery = true)
	public int setPaymentStatus(String orderEventStatusPaid, boolean isPaid, String orderEventOwnerAppRestaurant, long id);

}
