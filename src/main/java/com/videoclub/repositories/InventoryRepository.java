package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.videoclub.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	@Query(value = "select count(*) as cantidad from (select inventory_id from inventory where film_id = ?1 "
			+ "except select inventory_id from rental where return_date is null)", nativeQuery= true)
	Integer peliculasDisponibles(Integer filmId);

}
