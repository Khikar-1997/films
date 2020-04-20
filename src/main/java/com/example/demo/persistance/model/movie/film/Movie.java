package com.example.demo.persistance.model.movie.film;

import com.example.demo.persistance.model.AbstractBaseEntity;
import com.example.demo.persistance.model.movie.personal.actor.Actor;
import com.example.demo.persistance.model.movie.personal.director.Director;
import com.example.demo.persistance.model.movie.personal.producer.Producer;
import com.example.demo.persistance.model.movie.soundtrack.music.Soundtrack;
import com.example.demo.persistance.model.movie.trailer.Trailer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Movie extends AbstractBaseEntity {
    private String name;
    private String duration;
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;
    @OneToOne
    private Trailer trailer;
    @ManyToMany
    private Set<Actor> actors = new HashSet<>();
    @ManyToOne
    private Director director;
    @ManyToMany
    private Set<Producer> producers = new HashSet<>();
    @OneToOne
    private Soundtrack soundtrack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Soundtrack getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(Soundtrack soundtrack) {
        this.soundtrack = soundtrack;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Producer> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producer> producers) {
        this.producers = producers;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(duration, movie.duration) &&
                genre == movie.genre &&
                Objects.equals(trailer, movie.trailer) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(producers, movie.producers) &&
                Objects.equals(soundtrack, movie.soundtrack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, duration, genre, trailer, actors, director, producers, soundtrack);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", genre=" + genre +
                ", trailer=" + trailer +
                ", actors=" + actors +
                ", director=" + director +
                ", producers=" + producers +
                ", soundtrack=" + soundtrack +
                '}';
    }
}