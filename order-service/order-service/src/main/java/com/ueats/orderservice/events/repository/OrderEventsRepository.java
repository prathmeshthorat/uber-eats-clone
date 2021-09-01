package com.ueats.orderservice.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ueats.orderservice.events.entity.OrderEventsEntity;

@Repository
public interface OrderEventsRepository extends JpaRepository<OrderEventsEntity, Long> {

}
