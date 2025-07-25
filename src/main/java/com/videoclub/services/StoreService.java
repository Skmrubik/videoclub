package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Address;
import com.videoclub.entities.Store;
import com.videoclub.repositories.StoreRepository;

@RestController
public class StoreService {
	
	@Autowired
	StoreRepository storeRepository;
	
	@GetMapping("/listStores")
	public ResponseEntity<List<Store>> listStores() {
		try {
			List<Store> stores = storeRepository.findAll();
			return new ResponseEntity<>(stores, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
