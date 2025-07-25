package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}
