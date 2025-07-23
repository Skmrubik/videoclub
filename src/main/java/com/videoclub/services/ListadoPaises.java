package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Country;
import com.videoclub.repositories.CountryRepository;

@RestController
public class ListadoPaises {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	CountryRepository countryRepository;
	
	@GetMapping("/listCountries")
	public ResponseEntity<List<Country>> hello() {
		try {
			List<Country> countries = new ArrayList<Country>();
			countries = countryRepository.findAll();
			return new ResponseEntity<>(countries, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
