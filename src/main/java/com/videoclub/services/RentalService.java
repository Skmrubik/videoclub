package com.videoclub.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.dto.RentalsPending;
import com.videoclub.entities.City;
import com.videoclub.entities.Customer;
import com.videoclub.entities.Inventory;
import com.videoclub.entities.Rental;
import com.videoclub.entities.Staff;
import com.videoclub.repositories.CustomerRepository;
import com.videoclub.repositories.InventoryRepository;
import com.videoclub.repositories.RentalRepository;
import com.videoclub.repositories.StaffRepository;

@RestController
public class RentalService {

	@Autowired
	RentalRepository rentalRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
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
	
	@DeleteMapping("/deleteRentalById")
	public ResponseEntity deleteRentalById(@RequestParam String rentalId) {
		try {
			int id = Integer.parseInt(rentalId);
			int resp = rentalRepository.deleteRentalById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	@PostMapping(path = "/insertRental", consumes = "application/json")
	public ResponseEntity<Boolean> insertRental(@RequestParam String inventoryId, @RequestParam String customerId) {
		try {
			Rental rental = new Rental();
			Customer customer = customerRepository.getCustomerById(Integer.parseInt(customerId));
			Inventory inventory = inventoryRepository.getInventoryById(Integer.parseInt(inventoryId));
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        int semanasAAñadir = 2;
	        calendar.add(Calendar.WEEK_OF_YEAR, semanasAAñadir);
	        Date returnDateCalculate = calendar.getTime();
	        rental.setCustomerId(customer);
	        rental.setInventoryId(inventory);
	        rental.setReturnDate(null);
	        Staff staff = staffRepository.getStaffById(1);
	        rental.setStaffId(staff);
			rentalRepository.save(rental);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
