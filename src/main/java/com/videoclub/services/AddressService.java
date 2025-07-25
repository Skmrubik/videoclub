package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Address;
import com.videoclub.repositories.AddressRepository;

@RestController
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("/listAddress")
	public ResponseEntity<List<Address>> listAddress() {
		try {
			List<Address> listAddress = new ArrayList<>();
			listAddress = addressRepository.findAll();
			return new ResponseEntity<>(listAddress, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
