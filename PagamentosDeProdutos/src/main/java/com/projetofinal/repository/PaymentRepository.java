package com.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.entity.Payment;

public interface PaymentRepository  extends JpaRepository<Payment, Long>{

}
