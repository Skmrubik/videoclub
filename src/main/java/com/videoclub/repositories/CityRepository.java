package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.City;
import com.videoclub.entities.Country;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
	@Query(value = "select * from City c where country_id = ?1", nativeQuery = true)
	List<City> findByCountryId(int country);
	
}
