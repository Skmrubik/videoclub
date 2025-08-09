package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.dto.ValueLabel;
import com.videoclub.entities.Actor;
import com.videoclub.repositories.ActorRepository;

@RestController
public class ActorService {

	@Autowired
	ActorRepository actorRepository;
	
	@GetMapping("/listActors")
	public ResponseEntity<List<Actor>> listActors() {
		try {
			List<Actor> listActors = new ArrayList<>();
			listActors = actorRepository.findAll();
			return new ResponseEntity<>(listActors, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listActorsFormatted")
	public ResponseEntity<List<ValueLabel>> listActorsFormatted() {
		try {
			List<ValueLabel> listActors = new ArrayList<>();
			listActors = actorRepository.getAllActorFormatted();
			return new ResponseEntity<>(listActors, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
