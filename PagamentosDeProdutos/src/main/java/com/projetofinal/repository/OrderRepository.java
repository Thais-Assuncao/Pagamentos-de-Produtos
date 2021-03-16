package com.projetofinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetofinal.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findOrderByIdIn(List<Long> ordersIds);
	
	@Query(value = "SELECT * FROM orders WHERE order_status_id = 2", nativeQuery=true)
	List<Order> findOrdersWaiting();

	Optional<Order> findById(Long id);

	
	
	
}
