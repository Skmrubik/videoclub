package com.videoclub.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.videoclub.dto.FilmCategoryDTO;
import com.videoclub.entities.Category;
import com.videoclub.entities.Film;
import com.videoclub.entities.FilmCategory;
import com.videoclub.repositories.FilmRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class FilmController {
	
	@Autowired
	FilmRepository filmRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	
	public FilmController(FilmRepository filmRepository, EntityManager em) {
		this.filmRepository = filmRepository;
		this.em = em;
	}

	public List<Film> filterFilms() {
		List<Film> listFilms = filmRepository.findAll();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Film> criteriaQ = cb.createQuery(Film.class);
		Root<Film> root = criteriaQ.from(Film.class);
		List<Film> lista =  em.createQuery(criteriaQ).getResultList();
		return lista;
	}
	
	public List<FilmCategory> filterFilmsSelect() {
		List<Film> listFilms = filmRepository.findAll();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FilmCategory> criteriaQ = cb.createQuery(FilmCategory.class);
		Root<FilmCategory> root = criteriaQ.from(FilmCategory.class);
		Join<FilmCategory, Film> filmCategory = root.join("film_id");
		criteriaQ.multiselect(root.get("film_id"),filmCategory.get("title"));
		// Join<FilmCategory, Category> category = root.join("categoryId");
		List<FilmCategory> lista =  em.createQuery(criteriaQ).getResultList();
		return lista;
	}
}
