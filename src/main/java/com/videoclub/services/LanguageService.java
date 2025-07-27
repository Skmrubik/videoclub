package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Language;
import com.videoclub.repositories.LanguageRepository;

@RestController
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;
	
	@GetMapping("/listLanguages")
	public ResponseEntity<List<Language>> listLanguages() {
		try {
			List<Language> languages = new ArrayList<>();
			languages = languageRepository.findAll();
			return new ResponseEntity<>(languages, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
