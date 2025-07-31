package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.dto.FilmCategoryDTO;
import com.videoclub.entities.Film;

import jakarta.persistence.Tuple;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
	
	List<Film> findByLengthBetween(int min, int max);
	
	@Query(value = "select f.film_id, f.title, f.rental_rate, f.length, f.replacement_cost, c.name \r\n"
			+ "from film f inner join film_category f_c on f.film_id = f_c.film_id \r\n"
			+ "inner join category c on f_c.category_id = c.category_id", nativeQuery = true)
	List<FilmCategoryDTO> joinCategories();
}
