package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Inventory;
import com.videoclub.repositories.InventoryRepository;

@RestController
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;

	@GetMapping("/listInventories")
	public ResponseEntity<List<Inventory>> listInventories() {
		try {
			List<Inventory> inventories = new ArrayList<>();
			inventories = inventoryRepository.findAll();
			return new ResponseEntity<>(inventories, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
