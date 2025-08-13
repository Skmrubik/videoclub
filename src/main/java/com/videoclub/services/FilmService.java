package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.controllers.FilmController;
import com.videoclub.dto.FilmCategoryDTO;
import com.videoclub.dto.FilmPagination;
import com.videoclub.entities.Film;
import com.videoclub.entities.FilmCategory;
import com.videoclub.repositories.FilmRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;

@RestController
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	@PersistenceContext
	private EntityManager em;

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
	
	@GetMapping("/listFilmsFilter")
	public ResponseEntity<FilmPagination> listFilms2(@RequestParam String minDuration, @RequestParam String maxDuration, 
			@RequestParam String category, @RequestParam String actorId, @RequestParam String page) {
		try {
			int min = Integer.parseInt(minDuration);
			int max = Integer.parseInt(maxDuration);
			int catInt = Integer.parseInt(category);
			int actId = actorId == ""? 0 : Integer.parseInt(actorId);

			FilmController filmC = new FilmController(filmRepository, em);
			List<FilmCategory> films = filmC.filterFilmsSelect(min, max, catInt, actId);
			int currentPage = Integer.parseInt(page);	
			int tamPage = 12;
			int restoFilmsTamPage = films.size()%tamPage;
			int totalPages = ((films.size()-1)/tamPage)+1;		
			int firstFilm = (currentPage-1)*tamPage;
			int lastPageTam = restoFilmsTamPage == 0 ? tamPage : restoFilmsTamPage;
			int lastFilm = currentPage==totalPages ? (firstFilm+lastPageTam) : (currentPage)*tamPage;
			FilmPagination filmPagination = new FilmPagination(totalPages, currentPage, films.subList(firstFilm, lastFilm));
			return new ResponseEntity<>(filmPagination, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listFilmsBetweenDuration")
	public ResponseEntity<List<Film>> listFilmsBetweenYears(@RequestParam String minValue, @RequestParam String maxValue) {
		try {
			int min = Integer.parseInt(minValue);
			int max = Integer.parseInt(maxValue);
			List<Film> listFilms = new ArrayList<>();
			listFilms = filmRepository.findByLengthBetween(min, max);
			return new ResponseEntity<>(listFilms, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listFilmsCategory")
	public ResponseEntity<List<FilmCategoryDTO>> listFilmsCategory() {
		try {
			List<FilmCategoryDTO> listFilms = new ArrayList<>();
			//List<Tuple> list2 = filmRepository.joinCategories();
			listFilms = filmRepository.joinCategories();
			return new ResponseEntity<>(listFilms, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
