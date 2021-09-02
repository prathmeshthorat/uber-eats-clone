package com.ueats.orderservice.data;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRecordRequest {

	private long correlationId;

	private boolean isPaid;

	private String paymentMethod;

	private Timestamp createTime;

	private Timestamp paidTime;

	private Double amount;
}
