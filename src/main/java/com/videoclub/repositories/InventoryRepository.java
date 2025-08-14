package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.Customer;
import com.videoclub.entities.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	@Query(value = "select inventory_id from inventory where film_id = ?1 "
			+ "except select inventory_id from rental where return_date is null", nativeQuery= true)
	List<Integer> peliculasDisponibles(Integer filmId);
	
	@Query(value = "select * from Inventory i where i.inventory_id = ?1", nativeQuery = true)
	Inventory getInventoryById(Integer idInventory);

}
