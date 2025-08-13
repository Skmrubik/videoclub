package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.dto.RentalsPending;
import com.videoclub.entities.Rental;
import com.videoclub.repositories.RentalRepository;

@RestController
public class RentalService {

	@Autowired
	RentalRepository rentalRepository;
	
	@GetMapping("/listRentals")
	public ResponseEntity<List<Rental>> listRentals() {
		try {
			List<Rental> listRentals = new ArrayList<>();
			listRentals = rentalRepository.findAll();
			return new ResponseEntity<>(listRentals.subList(1, 10), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listRentalsPending")
	public ResponseEntity<List<RentalsPending>> listRentalsPending() {
		try {
			List<RentalsPending> listRentals = new ArrayList<>();
			listRentals = rentalRepository.rentalsPending();
			return new ResponseEntity<>(listRentals, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listRentalsPendingByCustomer")
	public ResponseEntity<List<RentalsPending>> listRentalsPendingByCustomerId(@RequestParam String customerId) {
		try {
			int id = Integer.parseInt(customerId);
			List<RentalsPending> listRentals = new ArrayList<>();
			listRentals = rentalRepository.rentalsPendingByCustomerId(id);
			return new ResponseEntity<>(listRentals, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
