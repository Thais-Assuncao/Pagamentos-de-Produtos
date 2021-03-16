package com.projetofinal.dto.response;

import com.projetofinal.entity.OrderStatus;
import com.projetofinal.entity.PaymentStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderStatusResponse {

	public OrderStatusResponse(OrderStatus orderStatus) {
		this.setName(orderStatus.getName());
		this.setCode((orderStatus.getCode() + String.format("%02d", orderStatus.getId())));
		this.setPaymentStatus(orderStatus.getPaymentStatus());
	}
		
	private String name;
		
	private String code;

	private PaymentStatus paymentStatus;
}
