package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.dto.RentalsPending;
import com.videoclub.entities.Rental;

import jakarta.transaction.Transactional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>{
	
	@Query(value = "select rental_id, f.title, rental_date, c.customer_id, c.first_name, c.last_name from rental r \r\n"
			+ "inner join inventory i on i.inventory_id = r.inventory_id\r\n"
			+ "inner join film f on f.film_id = i.film_id\r\n"
			+ "inner join customer c on c.customer_id = r.customer_id\r\n"
			+ "where return_date is null order by rental_date asc", nativeQuery= true)
	List<RentalsPending> rentalsPending();
	
	@Query(value = "select rental_id, f.title, rental_date, c.customer_id, c.first_name, c.last_name from rental r \r\n"
			+ "inner join inventory i on i.inventory_id = r.inventory_id\r\n"
			+ "inner join film f on f.film_id = i.film_id\r\n"
			+ "inner join customer c on c.customer_id = r.customer_id\r\n"
			+ "where return_date is null and c.customer_id = ?1 order by rental_date asc", nativeQuery= true)
	List<RentalsPending> rentalsPendingByCustomerId(int customerId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from payment r where r.rental_id = ?1; delete from rental r where r.rental_id = ?1", nativeQuery=true)
	int deleteRentalById(Integer rentalId);
}
