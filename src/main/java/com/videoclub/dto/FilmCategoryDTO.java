package com.videoclub.dto;

import java.math.BigDecimal;


public class FilmCategoryDTO {
	int film_id;
	String title;
	String description;
	BigDecimal rentalRate;
	Short length;
	BigDecimal replacementCost;
	String category;
	
	public FilmCategoryDTO() {
	}

	public FilmCategoryDTO(int film_id, String description, String title, BigDecimal rentalRate, Short length, BigDecimal replacementCost,
			String category) {
		this.film_id = film_id;
		this.description = description;
		this.title = title;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.category = category;
	}


	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getCategory_id() {
		return category;
	}

	public void setCategory_id(String category_id) {
		this.category = category_id;
	}
}
