package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Customer;
import com.videoclub.repositories.CustomerRepository;

@RestController
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/listCustomers")
	public ResponseEntity<List<Customer>> listCustomers() {
		try {
			List<Customer> listCustomer = new ArrayList<>();
			listCustomer = customerRepository.findAll();
			return new ResponseEntity<>(listCustomer, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
