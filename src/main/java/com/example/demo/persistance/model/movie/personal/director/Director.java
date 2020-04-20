package com.example.demo.persistance.model.movie.personal.director;


import com.example.demo.persistance.model.AbstractBaseEntity;
import com.example.demo.persistance.model.movie.personal.Profession;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Entity
public class Director extends AbstractBaseEntity {

    private String name;
    private String surname;
    private int age;
    @Enumerated(EnumType.STRING)
    private Profession profession;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return age == director.age &&
                Objects.equals(name, director.name) &&
                Objects.equals(surname, director.surname) &&
                profession == director.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, age, profession);
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}
