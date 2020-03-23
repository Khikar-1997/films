package com.example.demo.persistance.model.movie.film;

import com.example.demo.persistance.model.AbstractBaseEntity;
import com.example.demo.persistance.model.movie.personal.actor.Actor;
import com.example.demo.persistance.model.movie.personal.director.Director;
import com.example.demo.persistance.model.movie.personal.producer.Producer;
import com.example.demo.persistance.model.movie.soundtrack.music.Soundtrack;
import com.example.demo.persistance.model.movie.trailer.Trailer;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Objects;
import java.util.Set;

@Entity
public class Movie extends AbstractBaseEntity {
    private String name;
    private String duration;
    @OneToOne
    private Trailer trailer;
    @ManyToMany(mappedBy = "movie")
    private Set<Actor> actors;
    @ManyToOne
    private Director director;
    @ManyToMany(mappedBy = "movie")
    private Set<Producer> producers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(duration, movie.duration) &&
                Objects.equals(trailer, movie.trailer) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(producers, movie.producers) &&
                Objects.equals(soundtrack, movie.soundtrack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, duration, trailer, actors, director, producers, soundtrack);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", trailer=" + trailer +
                ", actors=" + actors +
                ", director=" + director +
                ", producers=" + producers +
                ", soundtrack=" + soundtrack +
                '}';
    }
}