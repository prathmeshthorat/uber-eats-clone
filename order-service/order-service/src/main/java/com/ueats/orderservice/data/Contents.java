package com.ueats.orderservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contents {
	
	private long correlationid;
	
	private long restaurantId;
	
	private long menuId;
	
	private String instructions;
}
