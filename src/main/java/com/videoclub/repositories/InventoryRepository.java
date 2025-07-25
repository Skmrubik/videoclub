package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoclub.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
