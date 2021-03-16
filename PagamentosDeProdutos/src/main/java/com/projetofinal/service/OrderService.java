package com.projetofinal.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.dto.request.OrderRequest;
import com.projetofinal.dto.request.OrderStatusRequestUpdate;
import com.projetofinal.dto.response.OrderResponse;
import com.projetofinal.entity.Client;
import com.projetofinal.entity.Order;
import com.projetofinal.entity.OrderStatus;
import com.projetofinal.entity.Payment;
import com.projetofinal.entity.PaymentStatus;
import com.projetofinal.entity.PaymentType;
import com.projetofinal.entity.Product;
import com.projetofinal.repository.ClientRepository;
import com.projetofinal.repository.OrderRepository;
import com.projetofinal.repository.OrderStatusRepository;
import com.projetofinal.repository.PaymentRepository;
import com.projetofinal.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public OrderResponse create(OrderRequest orderRequest) {
			Client client = clientRepository.findByEmail(orderRequest.getEmail()).orElseGet(() -> {
			Client clientSave = new Client(orderRequest.getEmail(), orderRequest.getEndereco());
			return clientRepository.save(clientSave);
		});

			Payment payment = new Payment(orderRequest.getPayment());
		
			if(payment.getType().equals(PaymentType.DEBIT)) {
				Random random = new Random(); 
				int numero = random.nextInt(21); 
				
				if(numero%2 == 0) {
					payment.setStatus(PaymentStatus.REPROVED);
				}	else {
					payment.setStatus(PaymentStatus.APPROVED);
				}
			} else {
				payment.setStatus(PaymentStatus.WAITING);
			}
			Payment paymentCreated = paymentRepository.save(payment);
			
			OrderStatus orderStatus = orderStatusRepository.findByPaymentStatus(paymentCreated.getStatus()).orElseThrow();
			
			List<Product> products = productRepository.findProductByIdIn(orderRequest.getProductsIds());
			
			Order order = new Order(orderRequest, client, paymentCreated, products, orderStatus);	
		
			order.setDate(LocalDateTime.now()); 
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-YYYY HH:mm");
			LocalDateTime dateTime = order.getDate();
			String formattedDateTime = dateTime.format(formatter);
			String finalDate = formattedDateTime.replaceAll("[^0-9]+", "");
			orderRepository.saveAndFlush(order);
			
			Long id = order.getId();
			String idString = Long.toString(id);
			 
			order.setCode(finalDate + idString);
			
			orderRepository.save(order);
			
			return new OrderResponse(order);
			
	}
	
	
	public List<OrderResponse> getStatus() {
		List<Order>ordersNewStatus = orderRepository.findOrdersWaiting();
		
		List<OrderResponse> ordersUpdate = new ArrayList<OrderResponse>();
		
		for (Order orderWithNewStatus : ordersNewStatus) {
			
			Random random = new Random(); 
			int numero = random.nextInt(2); 
			if(numero == 1) {
				Optional<OrderStatus> orderStatus = orderStatusRepository.findById(2L);
				orderWithNewStatus.setStatus(orderStatus.get());   
				orderRepository.save(orderWithNewStatus);
				ordersUpdate.add(new OrderResponse(orderWithNewStatus)); 
			} else if(numero == 2) {
				Optional<OrderStatus> orderStatus = orderStatusRepository.findById(1L);
				orderWithNewStatus.setStatus(orderStatus.get());
				orderRepository.save(orderWithNewStatus);
				ordersUpdate.add(new OrderResponse(orderWithNewStatus));
			} else {
				Optional<OrderStatus> orderStatus = orderStatusRepository.findById(3L);
				orderWithNewStatus.setStatus(orderStatus.get());
				orderRepository.save(orderWithNewStatus);
				ordersUpdate.add(new OrderResponse(orderWithNewStatus));
			}
		}
		return ordersUpdate;
	}
	
	public List<OrderResponse> getOrdersClient(Long id) {
		Optional<Client> client = clientRepository.findById(id);
				
		List<OrderResponse> ordersClientFinal = new ArrayList<OrderResponse>();
		
		List<Order> clientOrders = client.get().getOrders();
		
		for (Order order : clientOrders) {
			
			ordersClientFinal.add(new OrderResponse(order));
		}
			
		return ordersClientFinal;
	}
	
	public OrderResponse updateStatus(OrderStatusRequestUpdate orderStatusRequestUpdate, Long id) {
		
		Order order = orderRepository.findById(id).orElseThrow();
			
		OrderStatus status = order.getStatus();
		
		status.setPaymentStatus(orderStatusRequestUpdate.getPaymentStatus());
		
		orderRepository.saveAndFlush(order);
		
		return new OrderResponse(order);
	}


	

}

