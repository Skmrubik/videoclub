package com.videoclub.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	private int country_id;
	@Column(name = "country")
	private String country;
	@Column(name = "last_update")
	private Date last_update;
	
	public Country() {
		
	}
	public Country(int country_id, String country, Date last_update) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}
	
	public int getCountry_id() {
		return country_id;
	}
	
	public void setCountry_id(int country_id) {
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
