package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.FilmCategory;
import com.videoclub.entities.primarykeys.FilmCategoryId;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId>{

}
