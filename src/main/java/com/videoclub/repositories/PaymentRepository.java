package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoclub.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
