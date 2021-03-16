package com.projetofinal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetofinal.dto.request.ClientRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Client {

	public Client(ClientRequest clientRequest, List<Order> orders) {
		this.fillFromDto(clientRequest);
		this.setOrders(orders);
	}

	public void fillFromDto(ClientRequest clientRequest) {
		this.setAddress(clientRequest.getAddress());
		this.setEmail(clientRequest.getEmail());
		;
	}

	public Client(String email2, String address) {
		this.setEmail(email2);
		this.setAddress(address);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(nullable = false)
	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<Order>();
}
