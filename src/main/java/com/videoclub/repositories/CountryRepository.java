package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoclub.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
}
