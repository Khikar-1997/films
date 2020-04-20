package com.example.demo.rest.model.movie.soundtrack.music;

import java.io.Serializable;
import java.util.Objects;

public class SoundtrackRequestModel implements Serializable {

    private static final long serialVersionUID = 889750363382373763L;
    private String duration;
    private Long songId;
    private Long ComposerId;

    public SoundtrackRequestModel(String duration, Long songId, Long composerId) {
        this.duration = duration;
        this.songId = songId;
        ComposerId = composerId;
    }

    public SoundtrackRequestModel() {
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getComposerId() {
        return ComposerId;
    }

    public void setComposerId(Long composerId) {
        ComposerId = composerId;
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
        SoundtrackRequestModel that = (SoundtrackRequestModel) o;
        return Objects.equals(duration, that.duration) &&
                Objects.equals(songId, that.songId) &&
                Objects.equals(ComposerId, that.ComposerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, songId, ComposerId);
    }

    @Override
    public String toString() {
        return "SoundtrackRequestModel{" +
                "duration='" + duration + '\'' +
                ", songId=" + songId +
                ", ComposerId=" + ComposerId +
                '}';
    }
}