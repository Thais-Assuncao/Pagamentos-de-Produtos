package com.projetofinal.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.projetofinal.entity.PaymentType;

import lombok.Data;

@Data
public class PaymentRequest {

	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	
	@NotBlank
	private String paymentProcessesAdrress;
}
