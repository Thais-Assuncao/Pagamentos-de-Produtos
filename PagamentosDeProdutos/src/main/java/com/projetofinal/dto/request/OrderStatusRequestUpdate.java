package com.projetofinal.dto.request;

import javax.validation.constraints.NotNull;

import com.projetofinal.entity.PaymentStatus;

import lombok.Data;

@Data
public class OrderStatusRequestUpdate {

	@NotNull
	private PaymentStatus paymentStatus;
}
