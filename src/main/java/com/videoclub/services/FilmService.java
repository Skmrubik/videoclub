package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Film;
import com.videoclub.repositories.FilmRepository;

@RestController
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;

	@GetMapping("/listFilms")
	public ResponseEntity<List<Film>> listFilms() {
		try {
			List<Film> listFilms = new ArrayList<>();
			listFilms = filmRepository.findAll();
			return new ResponseEntity<>(listFilms, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
