package com.example.demo.persistance.model.movie.soundtrack.song;

import com.example.demo.persistance.model.AbstractBaseEntity;
import com.example.demo.persistance.model.movie.soundtrack.singer.Singer;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Song extends AbstractBaseEntity {
    private String name;
    private String duration;
    @ManyToOne
    private Singer singer;

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

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) &&
                Objects.equals(duration, song.duration) &&
                Objects.equals(singer, song.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, duration, singer);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", singer=" + singer +
                '}';
    }
}
