package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoclub.entities.FilmActor;
import com.videoclub.entities.primarykeys.FilmActorId;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId>{

}
