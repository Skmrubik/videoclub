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
@Table(name = "customer")
public class Customer {
	
	@Id
	private int customer_id;
	
	@Column(name = "store_id")
	private Integer storeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@JoinColumn(name = "address_id")
	@ManyToOne
	private Address addressId;
	
	@Column(name = "activebool")
	private Boolean activebool;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Column(name = "active")
	private Integer active;
	
	@OneToMany(mappedBy="customerId")
	@JsonIgnore
	private List<Payment> payments;
	
	
	public Customer() {
		payments = new ArrayList<>();
	}

	public List<Payment> getPayments() {
		return payments;
	}


	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}


	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public Boolean isActivebool() {
		return activebool;
	}

	public void setActivebool(Boolean activeBool) {
		this.activebool = activeBool;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
