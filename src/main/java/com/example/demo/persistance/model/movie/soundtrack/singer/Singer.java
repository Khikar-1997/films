package com.example.demo.persistance.model.movie.soundtrack.singer;

import com.example.demo.persistance.model.AbstractBaseEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Singer extends AbstractBaseEntity {

    private String name;
    private String surname;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Singer singer = (Singer) o;
        return Objects.equals(name, singer.name) &&
                Objects.equals(surname, singer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname);
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
