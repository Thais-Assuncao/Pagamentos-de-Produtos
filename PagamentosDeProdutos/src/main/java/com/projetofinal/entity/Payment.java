package com.projetofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projetofinal.dto.request.PaymentRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Payment {

	public Payment(PaymentRequest payment) {
		this.setType(payment.getType());
		this.setPaymentProcessesAdrress(payment.getPaymentProcessesAdrress());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@Column(nullable = false)
	private String paymentProcessesAdrress;
	
	
}
