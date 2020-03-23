package com.example.demo.rest.model.movie.film;

import java.io.Serializable;
import java.util.Objects;

public class MovieRequestModel implements Serializable {
    private static final long serialVersionUID = -8917184814694667220L;
    private String name;
    private String duration;
    private Long trailerId;
    private Long actorId;
    private Long directorId;
    private Long producerId;
    private Long soundtrackId;

    public MovieRequestModel(String name, String duration, Long trailerId, Long actorId, Long directorId, Long producerId, Long soundtrackId) {
        this.name = name;
        this.duration = duration;
        this.trailerId = trailerId;
        this.actorId = actorId;
        this.directorId = directorId;
        this.producerId = producerId;
        this.soundtrackId = soundtrackId;
    }

    public MovieRequestModel() {
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

    public Long getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(Long trailerId) {
        this.trailerId = trailerId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public Long getSoundtrackId() {
        return soundtrackId;
    }

    public void setSoundtrackId(Long soundtrackId) {
        this.soundtrackId = soundtrackId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRequestModel that = (MovieRequestModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(trailerId, that.trailerId) &&
                Objects.equals(actorId, that.actorId) &&
                Objects.equals(directorId, that.directorId) &&
                Objects.equals(producerId, that.producerId) &&
                Objects.equals(soundtrackId, that.soundtrackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, trailerId, actorId, directorId, producerId, soundtrackId);
    }

    @Override
    public String toString() {
        return "MovieRequestModel{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", trailerId=" + trailerId +
                ", actorId=" + actorId +
                ", directorId=" + directorId +
                ", producerId=" + producerId +
                ", soundtrackId=" + soundtrackId +
                '}';
    }
}
