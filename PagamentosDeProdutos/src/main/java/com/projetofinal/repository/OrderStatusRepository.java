package com.projetofinal.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetofinal.entity.OrderStatus;
import com.projetofinal.entity.PaymentStatus;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

	Optional<OrderStatus> findByPaymentStatus(PaymentStatus paymentStatus);
}
