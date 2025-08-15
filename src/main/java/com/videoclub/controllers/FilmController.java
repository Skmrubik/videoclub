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
	
	public List<FilmCategory> filterFilmsSelect(int lowValue, int highValue, int category, int actorId, int filmId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FilmCategory> criteriaQ = cb.createQuery(FilmCategory.class);
		Root<FilmCategory> root = criteriaQ.from(FilmCategory.class);
		Join<FilmCategory, Film> filmCategory = root.join("film_id", JoinType.INNER);
		Join<Film, FilmActor> filmJoinFilmActor = filmCategory.join("actors");
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.between(root.get("film_id").get("length"), Integer.valueOf(lowValue), Integer.valueOf(highValue)));
		if (filmId != 0) {
			predicates.add(cb.equal(root.get("film_id").get("film_id"), Integer.valueOf(filmId)));
		}
		if (category != 0) {
			predicates.add(cb.equal(root.get("categoryId").get("category_id"), Integer.valueOf(category)));
		}
		if (actorId != 0) {
			predicates.add(cb.equal(filmJoinFilmActor.get("actorId").get("actor_id"), actorId));
		}
		Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
		criteriaQ.where(predicatesArray);

		List<FilmCategory> lista =  em.createQuery(criteriaQ).getResultList();
		return lista;
	}
}
