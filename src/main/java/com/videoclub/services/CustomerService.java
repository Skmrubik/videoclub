package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.controllers.CustomerController;
import com.videoclub.entities.Address;
import com.videoclub.entities.City;
import com.videoclub.entities.Customer;
import com.videoclub.repositories.AddressRepository;
import com.videoclub.repositories.CityRepository;
import com.videoclub.repositories.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	CustomerController customerController;
	
	@PersistenceContext
    private EntityManager entityManager;
	
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
	
	@Transactional
	@PostMapping("/insertCustomer")
	public ResponseEntity<Boolean> insertCustomer(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String address1, @RequestParam String address2,
			@RequestParam String district, @RequestParam String city, @RequestParam String postalCode, 
			@RequestParam String phone) {
		try {
			Address address = new Address();
			address.setAddress(address1);
			address.setAddress2(address2);
			address.setDistrict(district);
			int cityInt = Integer.parseInt(city);
			
			City cityObj = cityRepository.findByCityId(cityInt);
			
			address.setCityId(cityObj);
			address.setPostalCode(postalCode);
			address.setPhone(phone);
			addressRepository.save(address);
			
			Customer customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			customer.setAddressId(address);
			customer.setActive(1);
			customer.setActivebool(true);
			customer.setStoreId(1);
			
			customerRepository.save(customer);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
