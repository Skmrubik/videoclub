package com.videoclub.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.videoclub.entities.primarykeys.FilmCategoryId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



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
