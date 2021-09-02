package com.ueats.restaurantservice.data;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderPriceReq {
	
	private long restaurantId;
	
	private Map<Long, Integer> itemQuantity;
}
