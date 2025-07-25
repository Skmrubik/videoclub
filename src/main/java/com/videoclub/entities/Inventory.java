package com.videoclub.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
@Entity(name = "inventory")
public class Inventory {
	
	@Id
	private int inventory_id;
	
	@Column(name="film_id")
	private Integer filmId;
	
	@Column(name="store_id")
	private Integer storeId;
	
	@Column(name="last_update")
	private Date lastUpdate;
	
	@OneToMany(mappedBy="inventoryId")
	private List<Rental> rentals;

	public Inventory() {
		rentals = new ArrayList<>();
	}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
