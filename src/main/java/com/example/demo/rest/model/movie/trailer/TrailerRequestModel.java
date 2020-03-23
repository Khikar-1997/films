package com.example.demo.rest.model.movie.trailer;

import java.io.Serializable;
import java.util.Objects;

public class TrailerRequestModel implements Serializable {
    private static final long serialVersionUID = 8040525118653889591L;
    private String duration;

    public TrailerRequestModel(String duration) {
        this.duration = duration;
    }

    public TrailerRequestModel() {
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
        TrailerRequestModel that = (TrailerRequestModel) o;
        return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }

    @Override
    public String toString() {
        return "TrailerRequestModel{" +
                "duration='" + duration + '\'' +
                '}';
    }
}