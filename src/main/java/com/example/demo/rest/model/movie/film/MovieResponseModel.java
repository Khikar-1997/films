package com.example.demo.rest.model.movie.film;

import com.example.demo.persistance.model.movie.film.MovieGenre;
import com.example.demo.persistance.model.movie.personal.actor.Actor;
import com.example.demo.persistance.model.movie.personal.producer.Producer;
import com.example.demo.rest.model.movie.personal.director.DirectorResponseModel;
import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackResponseModel;
import com.example.demo.rest.model.movie.trailer.TrailerResponseModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MovieResponseModel implements Serializable {
    private static final long serialVersionUID = -3610085409851108660L;
    private Long id;
    private String name;
    private String duration;
    private MovieGenre genre;
    private Set<Actor> actors = new HashSet<>();
    private DirectorResponseModel director;
    private Set<Producer> producers = new HashSet<>();
    private SoundtrackResponseModel soundtrack;
    private TrailerResponseModel trailer;

    public MovieResponseModel(Long id, String name, String duration, MovieGenre genre, Set<Actor> actors, DirectorResponseModel director, Set<Producer> producers, SoundtrackResponseModel soundtrack, TrailerResponseModel trailer) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.actors = actors;
        this.director = director;
        this.producers = producers;
        this.soundtrack = soundtrack;
        this.trailer = trailer;
    }

    public MovieResponseModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public DirectorResponseModel getDirector() {
        return director;
    }

    public void setDirector(DirectorResponseModel director) {
        this.director = director;
    }

    public SoundtrackResponseModel getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(SoundtrackResponseModel soundtrack) {
        this.soundtrack = soundtrack;
    }

    public TrailerResponseModel getTrailer() {
        return trailer;
    }

    public void setTrailer(TrailerResponseModel trailer) {
        this.trailer = trailer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        MovieResponseModel that = (MovieResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                genre == that.genre &&
                Objects.equals(actors, that.actors) &&
                Objects.equals(director, that.director) &&
                Objects.equals(producers, that.producers) &&
                Objects.equals(soundtrack, that.soundtrack) &&
                Objects.equals(trailer, that.trailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, genre, actors, director, producers, soundtrack, trailer);
    }

    @Override
    public String toString() {
        return "MovieResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", genre=" + genre +
                ", actors=" + actors +
                ", director=" + director +
                ", producers=" + producers +
                ", soundtrack=" + soundtrack +
                ", trailer=" + trailer +
                '}';
    }
}
