package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Actor;
import com.videoclub.entities.Film;
import com.videoclub.entities.FilmActor;
import com.videoclub.repositories.FilmActorRepository;

@RestController
public class FilmActorService {
	@Autowired
	FilmActorRepository filmActorRepository;
	
	@GetMapping("/listFilmActors")
	public ResponseEntity<List<FilmActor>> listFilmActors() {
		try {
			List<FilmActor> listFilmActors = new ArrayList<>();
			listFilmActors = filmActorRepository.findAll();
			return new ResponseEntity<>(listFilmActors, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listActorsOfFilms")
	public ResponseEntity<List<Actor>> listFilmActors(@RequestParam String idFilm) {
		try {
			int id = Integer.parseInt(idFilm);
			List<Actor> listFilmActors = new ArrayList<>();
			listFilmActors = filmActorRepository.getActorsOfFilm(id);
			return new ResponseEntity<>(listFilmActors, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
