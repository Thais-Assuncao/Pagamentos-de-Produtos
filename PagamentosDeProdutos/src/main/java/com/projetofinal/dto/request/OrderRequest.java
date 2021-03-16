package com.projetofinal.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	
	
	private List<Long> productsIds;
	
	
	private String email;
	
	
	private String endereco;
	
	
	private PaymentRequest payment;
	
	
	private String deliveredAddress;
	
	
}
