package com.videoclub.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {
	@Id
	private int film_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="release_year")
	private Integer releaseYear;
	
	@Column(name="language_id")
	private Integer languageId;
	
	@Column(name="rental_duration")
	private Integer rentalDuration;
	
	@Column(name="rental_rate")
	private Float rentalRate;
	
	@Column(name="length")
	private Integer length;
	
	@Column(name="replacement_cost")
	private Float replacementCost;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="last_update")
	private Date lastUpdate;
	
	@Column(name="special_features")
	private String specialFeatures;
	
	@Column(name="fulltext")
	private String fulltext;
	
	@OneToMany(mappedBy="filmId")
	@JsonIgnore
	private List<Inventory> inventories;

	public Film() {
		inventories = new ArrayList<>();
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Float getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Float rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Float getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Float replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	
	
	
}
