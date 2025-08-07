package com.videoclub.entities.primarykeys;

import java.io.Serializable;
import java.util.Objects;

import com.videoclub.entities.Category;
import com.videoclub.entities.Film;

public class FilmCategoryId implements Serializable {
	private Film film_id;
	private Category categoryId;
	
	public FilmCategoryId() {
	}

	public Film getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Film film_id) {
		this.film_id = film_id;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, film_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmCategoryId other = (FilmCategoryId) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(film_id, other.film_id);
	}

}
