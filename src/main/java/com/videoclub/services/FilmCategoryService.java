package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.FilmCategory;
import com.videoclub.repositories.FilmCategoryRepository;

@RestController
public class FilmCategoryService {
	@Autowired
	FilmCategoryRepository filmCategoryRepository;
	
	@GetMapping("/listFilmCategories")
	public ResponseEntity<List<FilmCategory>> listLanguages() {
		try {
			List<FilmCategory> listFilmCategories = new ArrayList<>();
			listFilmCategories = filmCategoryRepository.findAll();
			return new ResponseEntity<>(listFilmCategories, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
