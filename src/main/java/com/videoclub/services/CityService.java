package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.City;
import com.videoclub.entities.Country;
import com.videoclub.repositories.CityRepository;
import com.videoclub.repositories.CountryRepository;

@RestController
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@GetMapping("/listCities")
	public ResponseEntity<List<City>> listCities() {
		try {
			List<City> city = new ArrayList<>();
			city = cityRepository.findAll();
			return new ResponseEntity<>(city, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listCitiesByCountry")
	public ResponseEntity<List<City>> listCitiesByCountry(@RequestParam String country) {
		try {
			Country countryObj = countryRepository.findByCountry(country);
			Integer countryID = countryObj.getCountry_id();
			//List<City> city = cityRepository.findByCountryId(countryID);
			List<City> city = countryObj.getCities();
			return new ResponseEntity<>(city, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
