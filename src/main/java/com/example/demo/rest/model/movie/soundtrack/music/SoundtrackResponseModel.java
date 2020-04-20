package com.example.demo.rest.model.movie.soundtrack.music;

import com.example.demo.rest.model.movie.soundtrack.composer.ComposerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.song.SongResponseModel;

import java.io.Serializable;
import java.util.Objects;

public class SoundtrackResponseModel implements Serializable {

    private static final long serialVersionUID = 6786637002103315706L;
    private Long id;
    private String duration;
    private SongResponseModel song;
    private ComposerResponseModel composer;

    public SoundtrackResponseModel(Long id, String duration, SongResponseModel song, ComposerResponseModel composer) {
        this.id = id;
        this.duration = duration;
        this.song = song;
        this.composer = composer;
    }

    public SoundtrackResponseModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SongResponseModel getSong() {
        return song;
    }

    public void setSong(SongResponseModel song) {
        this.song = song;
    }

    public ComposerResponseModel getComposer() {
        return composer;
    }

    public void setComposer(ComposerResponseModel composer) {
        this.composer = composer;
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
        SoundtrackResponseModel that = (SoundtrackResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(song, that.song) &&
                Objects.equals(composer, that.composer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, song, composer);
    }

    @Override
    public String toString() {
        return "SoundtrackResponseModel{" +
                "id=" + id +
                ", duration='" + duration + '\'' +
                ", songId=" + song +
                ", composerId=" + composer +
                '}';
    }
}