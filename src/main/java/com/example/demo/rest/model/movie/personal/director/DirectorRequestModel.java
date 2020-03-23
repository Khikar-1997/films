package com.example.demo.rest.model.movie.personal.director;

import com.example.demo.persistance.model.movie.personal.Profession;

import java.io.Serializable;
import java.util.Objects;

public class DirectorRequestModel implements Serializable {
    private static final long serialVersionUID = 5300056335959811211L;
    private String name;
    private String surname;
    private int age;
    private Profession profession;

    public DirectorRequestModel(String name, String surname, int age, Profession profession) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }

    public DirectorRequestModel() {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorRequestModel that = (DirectorRequestModel) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                profession == that.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, profession);
    }

    @Override
    public String toString() {
        return "DirectorRequestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}
