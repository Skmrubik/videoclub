package com.videoclub.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	private int payment_id;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne
	private Customer customerId;
	
	@Column(name = "staff_id")
	private Integer staffId;
	
	@JoinColumn(name = "rental_id")
	@ManyToOne
	private Rental rentalId;
	
	@Column(name = "amount")
	private Float amount;
	
	@Column(name = "paymentDate")
	private Date paymentDate;

	public Payment() {
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Rental getRentalId() {
		return rentalId;
	}

	public void setRentalId(Rental rentalId) {
		this.rentalId = rentalId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
