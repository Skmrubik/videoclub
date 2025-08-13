package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.dto.ValueLabel;
import com.videoclub.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select c from Customer c where c.customer_id = ?1")
	Customer getCustomerById(Integer idCustomer);
	
	@Query(value = "select a.customer_id as value, concat(a.first_name,' ',a.last_name) as label from customer a", nativeQuery = true)
	List<ValueLabel> getAllCustomerFormatted();
}
