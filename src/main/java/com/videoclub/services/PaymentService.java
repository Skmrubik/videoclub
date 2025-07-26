package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Payment;
import com.videoclub.repositories.PaymentRepository;

@RestController
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@GetMapping("/listPayments")
	public ResponseEntity<List<Payment>> listPayments() {
		try {
			List<Payment> payments = new ArrayList<>();
			payments = paymentRepository.findAll();
			return new ResponseEntity<>(payments.subList(1, 10), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
