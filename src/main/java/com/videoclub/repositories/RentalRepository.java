package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>{
	
}
