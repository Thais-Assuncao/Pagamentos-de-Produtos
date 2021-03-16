package com.projetofinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.dto.request.OrderStatusRequest;
import com.projetofinal.dto.response.OrderStatusResponse;
import com.projetofinal.entity.OrderStatus;
import com.projetofinal.repository.OrderStatusRepository;

@Service
public class OrderStatusService {

	@Autowired
	public OrderStatusRepository orderStatusRepository;
	
	private OrderStatus findById(Long id) {
		Optional<OrderStatus> orderStatusOptional = this.orderStatusRepository.findById(id);
		OrderStatus orderStatus = orderStatusOptional.orElseThrow();
		return orderStatus;
	}
	
	
	public OrderStatusResponse create(OrderStatusRequest orderStatusRequest) {
		OrderStatus newOrderStatus = new OrderStatus(orderStatusRequest);
		this.orderStatusRepository.save(newOrderStatus);
		return new OrderStatusResponse(newOrderStatus);
	}
	
	public OrderStatusResponse update(OrderStatusRequest orderStatusRequest, Long id) {
		OrderStatus orderStatus = this.findById(id);
		orderStatus.fillFromDto(orderStatusRequest);
		this.orderStatusRepository.save(orderStatus);
		return new OrderStatusResponse(orderStatus);
	}
}
