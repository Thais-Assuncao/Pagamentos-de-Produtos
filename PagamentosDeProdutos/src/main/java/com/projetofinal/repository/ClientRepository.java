package com.projetofinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetofinal.entity.Client;
import com.projetofinal.entity.Order;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByEmail(String email);
	
	List<Order> findOrderByIdIn(List<Long> ordersIds);
 
}
