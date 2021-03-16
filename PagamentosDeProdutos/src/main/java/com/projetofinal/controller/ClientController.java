package com.projetofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.dto.request.ClientRequest;
import com.projetofinal.dto.response.ClientResponse;
import com.projetofinal.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ClientResponse post(@Valid @RequestBody ClientRequest clientRequest) {
		return this.clientService.create(clientRequest);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ClientResponse put(@Valid @RequestBody ClientRequest clientRequest, @PathVariable Long id) {
		return this.clientService.update(clientRequest, id);
	}
	
	@GetMapping(produces = "application/json")
	public List<ClientResponse> get() {
		return this.clientService.getAll();
	}
	
}
