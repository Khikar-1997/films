package com.example.demo.rest.model.movie.soundtrack.song;

import java.io.Serializable;
import java.util.Objects;

public class SongRequestModel implements Serializable {

    private static final long serialVersionUID = -7241894746171494529L;
    private String name;
    private String duration;
    private Long singerId;

    public SongRequestModel(String name, String duration, Long singerId) {
        this.name = name;
        this.duration = duration;
        this.singerId = singerId;
    }

    public SongRequestModel() {
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

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequestModel that = (SongRequestModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(singerId, that.singerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, singerId);
    }

    @Override
    public String toString() {
        return "SongRequestModel{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", singerId=" + singerId +
                '}';
    }
}
