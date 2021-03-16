package com.projetofinal.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.projetofinal.entity.PaymentStatus;

import lombok.Data;

@Data
public class OrderStatusRequest {


	@Size(min = 2, max = 255)
	@NotBlank
	private String name;
	
	@Size(min = 3, max = 3)
	@NotBlank
	private String code;

	@NotNull
	private PaymentStatus paymentStatus;
	
}
