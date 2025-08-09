package com.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.videoclub.dto.ValueLabel;
import com.videoclub.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{

	@Query(value = "select a.actor_id as value, concat(a.first_name,' ',a.last_name) as label from actor a", nativeQuery = true)
	List<ValueLabel> getAllActorFormatted();
}
