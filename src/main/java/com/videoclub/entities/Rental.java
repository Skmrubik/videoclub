package com.videoclub.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rental")
public class Rental {
	
	@Id
	private int rental_id;
	
	@Column(name = "rental_date")
	private Date rentalDate;
	
	@JoinColumn(name = "inventory_id")
	@ManyToOne
	private Inventory inventoryId;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne
	private Customer customerId;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	@JoinColumn(name = "staff_id")
	@ManyToOne
	private Staff staffId;
	
	@Column(name = "last_update")
	private Date lastUpdate;

	public Rental() {
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Inventory getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Inventory inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Staff getStaffId() {
		return staffId;
	}

	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
