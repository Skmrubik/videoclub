package com.videoclub.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.videoclub.dto.FilmCategoryDTO;
import com.videoclub.entities.Category;
import com.videoclub.entities.Film;
import com.videoclub.entities.FilmActor;
import com.videoclub.entities.FilmCategory;
import com.videoclub.repositories.FilmRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
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
	
	public List<FilmCategory> filterFilmsSelect(int lowValue, int highValue, int category, int actorId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FilmCategory> criteriaQ = cb.createQuery(FilmCategory.class);
		Root<FilmCategory> root = criteriaQ.from(FilmCategory.class);
		Join<FilmCategory, Film> filmCategory = root.join("film_id");
		Join<Film, FilmActor> filmJoinFilmActor = filmCategory.join("actors");

		Predicate predicate = cb.between(root.get("film_id").get("length"), Integer.valueOf(lowValue), Integer.valueOf(highValue));
		//Predicate predicate = cb.and(cb.greaterThanOrEqualTo(filmCategory.get("length"), lowValue),cb.lessThanOrEqualTo(filmCategory.get("length"), highValue));
		if (category != 0) {
			predicate = cb.and(predicate, cb.equal(root.get("categoryId").get("category_id"), category));
		}
		if (actorId != 0) {
			predicate = cb.and(predicate, cb.equal(filmJoinFilmActor.get("actorId").get("actor_id"), actorId));
		}
		criteriaQ.where(predicate);

		List<FilmCategory> lista =  em.createQuery(criteriaQ).getResultList();
		return lista;
	}
}
