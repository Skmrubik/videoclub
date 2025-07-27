package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Category;
import com.videoclub.repositories.CategoryRepository;

@RestController
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/listCategories")
	public ResponseEntity<List<Category>> listCategories() {
		try {
			List<Category> listCategories = new ArrayList<>();
			listCategories = categoryRepository.findAll();
			return new ResponseEntity<>(listCategories, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
