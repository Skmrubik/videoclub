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
import jakarta.persistence.Transient;

@Entity
@Table(name = "country")
public class Country {
	@Id
	private Integer country_id;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "last_update")
	private Date last_update;
	
	@OneToMany(mappedBy = "countryId")
	@JsonIgnore
	private List<City> cities;
	
	public Country() {
		cities = new ArrayList<>();
	}
	
	public Country(int country_id, String country, Date last_update) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}
	
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Integer getCountry_id() {
		return country_id;
	}
	
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Date getLast_update() {
		return last_update;
	}
	
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
}
