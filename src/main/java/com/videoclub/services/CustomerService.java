package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.videoclub.controllers.CustomerController;
import com.videoclub.dto.ValueLabel;
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
	
	@GetMapping("/listCustomersFormatted")
	public ResponseEntity<List<ValueLabel>> listCustomersFormatted() {
		try {
			List<ValueLabel> listCustomer = new ArrayList<>();
			listCustomer = customerRepository.getAllCustomerFormatted();
			return new ResponseEntity<>(listCustomer, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getCustomerById")
	public ResponseEntity<Customer> getCustomerById(@RequestParam String idCustomer) {
		try {
			int id = Integer.parseInt(idCustomer);
			Customer customer = customerRepository.getCustomerById(id);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/* Ejemplo de JSON
		{
		    "firstName": "Jorge",
		    "lastName": "Castillo",
		    "email": "a@mail.com",
		    "addressId": {
		        "address": "Calle a",
		        "address2": "Calle b",
		        "district": "1",
		        "cityId": {
		            "city_id": 424
		        },
		        "postalCode": "12345",
		        "phone": "123456789"
		    }
		}
	*/
	@Transactional
	@PostMapping(path = "/insertCustomer", consumes = "application/json")
	public ResponseEntity<Boolean> insertCustomerBody(@RequestBody Customer customer) {
		try {
			//Atributos por defecto
			customer.setActive(1);
			customer.setActivebool(true);
			customer.setStoreId(1);
			//Guardado de objetos en BBDD
			City cityObj = cityRepository.findByCityId(customer.getAddressId().getCityId().getCity_id());
			customer.getAddressId().setCityId(cityObj);
			addressRepository.save(customer.getAddressId());
			customerRepository.save(customer);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
