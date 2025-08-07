package com.videoclub.entities.primarykeys;

import java.io.Serializable;
import java.util.Objects;

import com.videoclub.entities.Actor;
import com.videoclub.entities.Film;

public class FilmActorId {

	// Los nombres de los atributos aquí DEBEN coincidir
	// con los nombres de los atributos @Id en la entidad FilmActor
	private Actor actorId;
	private Film filmId;

	// Constructor por defecto es OBLIGATORIO para JPA
	public FilmActorId() {
	}

	public FilmActorId(Actor actorId, Film filmId) {
		this.actorId = actorId;
		this.filmId = filmId;
	}

	// --- ¡CRUCIAL! Sobreescribe equals() y hashCode() ---
	// Esto es fundamental para que JPA pueda identificar correctamente
	// las instancias de la clave compuesta en el contexto de persistencia.
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FilmActorId that = (FilmActorId) o;
		return actorId == that.actorId && filmId == that.filmId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId);
	}

	// Getters y Setters (opcionales para una clase de ID, pero buena práctica)
	public Actor getActorId() {
		return actorId;
	}

	public void setActorId(Actor actorId) {
		this.actorId = actorId;
	}

	public Film getFilmId() {
		return filmId;
	}

	public void setFilmId(Film filmId) {
		this.filmId = filmId;
	}

}
