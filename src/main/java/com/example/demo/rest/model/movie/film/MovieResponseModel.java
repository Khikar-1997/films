package com.example.demo.rest.model.movie.film;

import com.example.demo.rest.model.movie.personal.actor.ActorResponseModel;
import com.example.demo.rest.model.movie.personal.director.DirectorResponseModel;
import com.example.demo.rest.model.movie.personal.producer.ProducerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackResponseModel;
import com.example.demo.rest.model.movie.trailer.TrailerResponseModel;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class MovieResponseModel implements Serializable {
    private static final long serialVersionUID = -3610085409851108660L;
    private Long id;
    private String name;
    private String duration;
    private Set<ActorResponseModel> actor;
    private DirectorResponseModel director;
    private Set<ProducerResponseModel> producer;
    private SoundtrackResponseModel soundtrack;
    private TrailerResponseModel trailer;

    public MovieResponseModel(Long id, String name, String duration, Set<ActorResponseModel> actor, DirectorResponseModel director, Set<ProducerResponseModel> producer, SoundtrackResponseModel soundtrack, TrailerResponseModel trailer) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.actor = actor;
        this.director = director;
        this.producer = producer;
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

    public Set<ActorResponseModel> getActor() {
        return actor;
    }

    public void setActor(Set<ActorResponseModel> actor) {
        this.actor = actor;
    }

    public Set<ProducerResponseModel> getProducer() {
        return producer;
    }

    public void setProducer(Set<ProducerResponseModel> producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieResponseModel that = (MovieResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(actor, that.actor) &&
                Objects.equals(director, that.director) &&
                Objects.equals(producer, that.producer) &&
                Objects.equals(soundtrack, that.soundtrack) &&
                Objects.equals(trailer, that.trailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, actor, director, producer, soundtrack, trailer);
    }

    @Override
    public String toString() {
        return "MovieResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", actorId=" + actor +
                ", directorId=" + director +
                ", producerId=" + producer +
                ", soundtrackId=" + soundtrack +
                ", trailerId=" + trailer +
                '}';
    }
}
