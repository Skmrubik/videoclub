package com.videoclub.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	@Id
	private Integer city_id;
	
	@Column(name = "city")
	private String city;
	
	@JoinColumn(name = "country_id")
	@ManyToOne
	private Country countryId;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@OneToMany(mappedBy = "cityId")
	@JsonIgnore
	List<Address> listAddress;

	public City() {
		listAddress = new ArrayList<>();
	}

	
	public List<Address> getListAddress() {
		return listAddress;
	}


	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}


	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountryId() {
		return countryId;
	}

	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
