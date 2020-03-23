package com.example.demo.persistance.model.movie.trailer;

import com.example.demo.persistance.model.AbstractBaseEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Trailer extends AbstractBaseEntity {
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trailer trailer = (Trailer) o;
        return Objects.equals(duration, trailer.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "duration='" + duration + '\'' +
                '}';
    }
}
