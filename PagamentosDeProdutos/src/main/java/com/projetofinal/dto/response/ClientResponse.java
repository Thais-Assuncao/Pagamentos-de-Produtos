package com.projetofinal.dto.response;

import java.util.List;

import com.projetofinal.entity.Client;
import com.projetofinal.entity.Order;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientResponse {
	
	
	public ClientResponse(Client client) {
		this.setAddress(client.getAddress());
		this.setEmail(client.getEmail());
		this.setOrders(client.getOrders());
		this.setId(client.getId());
	}
	
	private Long id;
		
	private String email;
	
	private String address;
	
	private List<Order> orders;
}
