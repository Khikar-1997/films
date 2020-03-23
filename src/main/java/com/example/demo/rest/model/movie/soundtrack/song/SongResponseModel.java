package com.example.demo.rest.model.movie.soundtrack.song;

import com.example.demo.rest.model.movie.soundtrack.singer.SingerResponseModel;

import java.io.Serializable;
import java.util.Objects;

public class SongResponseModel implements Serializable {
    private static final long serialVersionUID = 1173630571363201932L;
    private Long id;
    private String name;
    private String duration;
    private SingerResponseModel singer;

    public SongResponseModel(Long id, String name, String duration, SingerResponseModel singer) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.singer = singer;
    }

    public SongResponseModel() {
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

    public SingerResponseModel getSinger() {
        return singer;
    }

    public void setSinger(SingerResponseModel singer) {
        this.singer = singer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongResponseModel that = (SongResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(singer, that.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, singer);
    }

    @Override
    public String toString() {
        return "SongResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", singerId=" + singer +
                '}';
    }
}
