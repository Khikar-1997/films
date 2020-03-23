package com.example.demo.persistance.model.movie.soundtrack.composer;

import com.example.demo.persistance.model.AbstractBaseEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Composer extends AbstractBaseEntity {
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
        Composer composer = (Composer) o;
        return Objects.equals(name, composer.name) &&
                Objects.equals(surname, composer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname);
    }

    @Override
    public String toString() {
        return "Composer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
