package com.ueats.paymentservice.scheduler;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventScheduler {
	
	//@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		log.info("The time is now {}", Timestamp.from(Instant.now()));
	}
}
