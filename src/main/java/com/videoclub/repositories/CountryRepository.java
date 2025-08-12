package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.dto.ValueLabel;
import com.videoclub.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	Country findByCountry(String country);
	
	@Query(value = "select c.country_id as value, c.country as label from country c", nativeQuery=true)
	List<ValueLabel> getAllCountriesFormatted();
	
}
