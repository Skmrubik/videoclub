package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
