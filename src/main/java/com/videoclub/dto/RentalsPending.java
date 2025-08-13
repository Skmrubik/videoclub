package com.videoclub.dto;

import java.util.Date;

public class RentalsPending {
	private int rental_id;
	private String title;
	private Date rental_date;
	private int customer_id;
	private String first_name;
	private String last_name;
	
	public RentalsPending(int rental_id, String title, Date rental_date,int customer_id, String first_name, String last_name) {
		this.rental_id = rental_id;
		this.title = title;
		this.rental_date = rental_date;
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRental_date() {
		return rental_date;
	}

	public void setRental_date(Date rental_date) {
		this.rental_date = rental_date;
	}

	
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
}
