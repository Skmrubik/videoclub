package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.dto.ValueLabel;
import com.videoclub.entities.City;
import com.videoclub.entities.Country;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
	@Query(value = "select c.city_id as value, c.city as label from City c where country_id = ?1", nativeQuery = true)
	List<ValueLabel> findByCountryId(Integer country);
	
	@Query("select c from City c where c.city_id = ?1")
	City findByCityId(Integer cityId);
	
}
