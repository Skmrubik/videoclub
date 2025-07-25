package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	Country findByCountry(String country);
}
