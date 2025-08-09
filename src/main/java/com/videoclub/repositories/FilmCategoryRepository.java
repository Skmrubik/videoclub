package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.FilmCategory;
import com.videoclub.entities.primarykeys.FilmCategoryId;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId>{
	
	@Query("SELECT f_c FROM FilmCategory f_c "
			+ "INNER JOIN FilmActor f_a ON f_c.film_id.film_id = f_a.filmId.film_id WHERE f_a.actorId.actor_id = ?1")
	List<FilmCategory> getFilmsOfActor(Integer idActor);
}
