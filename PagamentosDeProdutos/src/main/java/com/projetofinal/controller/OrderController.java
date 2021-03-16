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

import com.projetofinal.dto.request.OrderRequest;
import com.projetofinal.dto.request.OrderStatusRequestUpdate;
import com.projetofinal.dto.response.OrderResponse;
import com.projetofinal.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public OrderResponse post(@Valid @RequestBody OrderRequest orderRequest) {
		System.out.println(orderRequest);
		return this.orderService.create(orderRequest);
	}

	@GetMapping(produces = "application/json")
	public List<OrderResponse> get() {
		return this.orderService.getStatus();
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public List<OrderResponse> get(@PathVariable Long id) {
		return this.orderService.getOrdersClient(id);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public OrderResponse put(@Valid @RequestBody OrderStatusRequestUpdate orderStatusRequestUpdate, @PathVariable Long id) {
		return this.orderService.updateStatus(orderStatusRequestUpdate, id);
	}
}
