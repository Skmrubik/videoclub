package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.Actor;
import com.videoclub.entities.FilmActor;
import com.videoclub.entities.primarykeys.FilmActorId;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId>{

	@Query("select f_a.actorId from FilmActor f_a where f_a.filmId.film_id = ?1")
	List<Actor> getActorsOfFilm(Integer idFilm);
}
