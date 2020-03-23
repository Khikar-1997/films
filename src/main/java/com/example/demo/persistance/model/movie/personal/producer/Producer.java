package com.example.demo.persistance.model.movie.personal.producer;

import com.example.demo.persistance.model.AbstractBaseEntity;
import com.example.demo.persistance.model.movie.film.Movie;
import com.example.demo.persistance.model.movie.personal.Profession;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Producer extends AbstractBaseEntity {
    private String name;
    private String surname;
    private int age;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @ManyToMany
    private Set<Movie> movie;

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

    public Set<Movie> getMovie() {
        return movie;
    }

    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Producer producer = (Producer) o;
        return age == producer.age &&
                Objects.equals(name, producer.name) &&
                Objects.equals(surname, producer.surname) &&
                profession == producer.profession &&
                Objects.equals(movie, producer.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, age, profession, movie);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                ", movie=" + movie +
                '}';
    }
}
