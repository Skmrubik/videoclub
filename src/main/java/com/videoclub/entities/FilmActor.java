package com.videoclub.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

class FilmActorId implements Serializable {

    // Los nombres de los atributos aquí DEBEN coincidir
    // con los nombres de los atributos @Id en la entidad FilmActor
    private int actorId; 
    private Film filmId;

    // Constructor por defecto es OBLIGATORIO para JPA
    public FilmActorId() {
    }

    public FilmActorId(int actorId, Film filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    // --- ¡CRUCIAL! Sobreescribe equals() y hashCode() ---
    // Esto es fundamental para que JPA pueda identificar correctamente
    // las instancias de la clave compuesta en el contexto de persistencia.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return actorId == that.actorId &&
               filmId == that.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

    // Getters y Setters (opcionales para una clase de ID, pero buena práctica)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }
}

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId.class)
public class FilmActor {
	@Id
	@JoinColumn(name = "actor_id")
	private int actorId;

    @JoinColumn(name = "film_id")
	@Id
	@OneToOne
	private Film filmId;
	
	@Column(name = "last_update")
	private Date lastUpdate;

	public FilmActor() {
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public Film getFilmId() {
		return filmId;
	}

	public void setFilmId(Film filmId) {
		this.filmId = filmId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
