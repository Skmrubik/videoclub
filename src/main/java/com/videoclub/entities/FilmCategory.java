package com.videoclub.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

class FilmCategoryId implements Serializable {
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

@Entity
@Table(name="film_category")
@IdClass(FilmCategoryId.class)
public class FilmCategory {
	@Id
	@JoinColumn(name = "film_id", referencedColumnName = "film_id")
	@OneToOne
	private Film film_id;
	
	@Id
	@JoinColumn(name = "category_id")
	@OneToOne
	private Category categoryId;
	
	@Column(name = "last_update")
	private Date lastUpdate;

	public FilmCategory() {
	}

	
	public FilmCategory(Film film_id, Category categoryId, Date lastUpdate) {
		this.film_id = film_id;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
