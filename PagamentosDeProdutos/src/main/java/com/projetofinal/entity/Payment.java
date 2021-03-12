package com.projetofinal.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
//@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "payment_type_id", referencedColumnName = "id")
	private PaymentType type;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "payment_status_id", referencedColumnName = "id")
	private PaymentStatus status;
	
	@Column(nullable = false)
	private String paymentProcessesAdrress;
	
	
}
