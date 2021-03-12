package com.projetofinal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projetofinal.dto.request.ClientRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Client {
	
	public Client(ClientRequest clientRequest) {
		this.fillFromDto(clientRequest);
	}
	
	public void fillFromDto(ClientRequest clientRequest) {
		this.setAddress(clientRequest.getAddress());
		this.setEmail(clientRequest.getEmail());
		this.setOrders(clientRequest.getOrders());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String address;
	
	@ElementCollection
	private List<String> orders = new ArrayList<String>();
}
