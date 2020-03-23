package com.example.demo.rest.model.movie.personal.producer;

import com.example.demo.persistance.model.movie.personal.Profession;

import java.io.Serializable;
import java.util.Objects;

public class ProducerRequestModel implements Serializable {
    private static final long serialVersionUID = -3889614946334801877L;
    private String name;
    private String surname;
    private int age;
    private Profession profession;
    private Long movieId;

    public ProducerRequestModel(String name, String surname, int age, Profession profession, Long movieId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
        this.movieId = movieId;
    }

    public ProducerRequestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducerRequestModel that = (ProducerRequestModel) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                profession == that.profession &&
                Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, profession, movieId);
    }

    @Override
    public String toString() {
        return "ProducerRequestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                ", movieId=" + movieId +
                '}';
    }
}