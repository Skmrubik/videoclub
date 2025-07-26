package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoclub.entities.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
