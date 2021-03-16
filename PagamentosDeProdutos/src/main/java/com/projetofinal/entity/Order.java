package com.projetofinal.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.projetofinal.dto.request.OrderRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

	public Order(OrderRequest orderRequest, Client client, Payment payment, List<Product> products, OrderStatus orderStatus) {
		this.setClient(client);
		this.setDeliveredAddress(orderRequest.getDeliveredAddress());
		this.setProducts(products);
		this.setPayment(payment);
		this.setStatus(orderStatus);
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "order_products",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "orderStatus_id", referencedColumnName = "id")
	private OrderStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id", referencedColumnName = "id")
	private Payment payment;
	
	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime date;
	
	@Column(name = "code")
	private String code;

	@Column(nullable = false)
	private String deliveredAddress;
}
