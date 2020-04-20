package com.example.demo.rest.model.movie.personal.producer;

import com.example.demo.persistance.model.movie.personal.Profession;

import java.io.Serializable;
import java.util.Objects;

public class ProducerResponseModel implements Serializable {
    private static final long serialVersionUID = -5302955907559614961L;
    private Long id;
    private String name;
    private String surname;
    private int age;
    private Profession profession;

    public ProducerResponseModel(Long id, String name, String surname, int age, Profession profession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }

    public ProducerResponseModel() {
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
        ProducerResponseModel that = (ProducerResponseModel) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                profession == that.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, profession);
    }

    @Override
    public String toString() {
        return "ProducerResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}