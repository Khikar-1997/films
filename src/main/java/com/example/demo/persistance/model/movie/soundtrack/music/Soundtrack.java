package com.example.demo.persistance.model.movie.soundtrack.music;

import com.example.demo.persistance.model.AbstractBaseEntity;
import com.example.demo.persistance.model.movie.soundtrack.composer.Composer;
import com.example.demo.persistance.model.movie.soundtrack.song.Song;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Soundtrack extends AbstractBaseEntity {
    private String duration;
    @OneToOne
    private Song song;
    @OneToOne
    private Composer composer;

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

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
        Soundtrack that = (Soundtrack) o;
        return Objects.equals(duration, that.duration) &&
                Objects.equals(song, that.song) &&
                Objects.equals(composer, that.composer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration, song, composer);
    }

    @Override
    public String toString() {
        return "Soundtrack{" +
                "duration='" + duration + '\'' +
                ", song=" + song +
                ", composer=" + composer +
                '}';
    }
}
