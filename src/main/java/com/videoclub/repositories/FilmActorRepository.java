package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.FilmActor;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, Integer>{

}
