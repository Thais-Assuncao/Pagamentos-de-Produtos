package com.projetofinal.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.entity.Client;
import com.projetofinal.entity.Order;
import com.projetofinal.entity.OrderStatus;
import com.projetofinal.entity.Product;

import lombok.Data;

@Data
public class OrderResponse {
	
	public OrderResponse(Order order) {
		
		this.setProducts(order.getProducts());
		this.setCodeOrder(order.getCode());
		this.setOrderStatus(order.getStatus());
		this.setDate(order.getDate());
		this.setClient(order.getClient());
	}


	@JsonIgnore
	private Client client;
	
	private List<Product> products;
	
	private String codeOrder;
	
	private OrderStatus orderStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss") 
	private LocalDateTime date;
	
	
}
