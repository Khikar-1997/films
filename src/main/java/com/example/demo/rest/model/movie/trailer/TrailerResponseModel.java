package com.example.demo.rest.model.movie.trailer;

import java.io.Serializable;
import java.util.Objects;

public class TrailerResponseModel implements Serializable {
    private static final long serialVersionUID = -1754293582124465902L;
    private Long id;
    private String duration;

    public TrailerResponseModel(Long id, String duration) {
        this.id = id;
        this.duration = duration;
    }

    public TrailerResponseModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrailerResponseModel that = (TrailerResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration);
    }

    @Override
    public String toString() {
        return "TrailerResponseModel{" +
                "id=" + id +
                ", duration='" + duration + '\'' +
                '}';
    }
}
