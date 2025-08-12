package com.videoclub.controllers;


import com.videoclub.entities.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CustomerController {

    private EntityManager entityManager;
	
	public CustomerController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
    public long saveCustomer(Customer customer){
        entityManager.persist(customer);
        return customer.getCustomer_id();
    }
}
