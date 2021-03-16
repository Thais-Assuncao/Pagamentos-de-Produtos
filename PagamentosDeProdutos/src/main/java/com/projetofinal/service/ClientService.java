package com.projetofinal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.dto.request.ClientRequest;
import com.projetofinal.dto.response.ClientResponse;
import com.projetofinal.entity.Client;
import com.projetofinal.entity.Order;
import com.projetofinal.repository.ClientRepository;
import com.projetofinal.repository.OrderRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	private Client findById(Long id) {
		Optional<Client> clientOptional = this.clientRepository.findById(id);
		Client client = clientOptional.orElseThrow();
		return client;
	}
		
	public ClientResponse create(ClientRequest clientRequest) {
		
		List<Order> orders = orderRepository.findOrderByIdIn(clientRequest.getOrdersIds());
		Client newClient = new Client(clientRequest,orders);
		this.clientRepository.save(newClient);
		return new ClientResponse(newClient);
	}	
	
	public ClientResponse update(ClientRequest clientRequest, Long id) {
		Client client = this.findById(id);
		client.fillFromDto(clientRequest);
		this.clientRepository.save(client);
		return new ClientResponse(client);
	}
	
	public List<ClientResponse> getAll() {
		return this.clientRepository.findAll().stream().map(ClientResponse::new).collect(Collectors.toList());
	}
}
