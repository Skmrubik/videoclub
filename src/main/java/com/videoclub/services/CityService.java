package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.City;
import com.videoclub.entities.Country;
import com.videoclub.repositories.CityRepository;

@RestController
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@GetMapping("/listCities")
	public ResponseEntity<List<City>> hello() {
		try {
			List<City> city = new ArrayList<>();
			city = cityRepository.findAll();
			return new ResponseEntity<>(city, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
