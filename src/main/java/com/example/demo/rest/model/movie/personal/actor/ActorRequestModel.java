package com.example.demo.rest.model.movie.personal.actor;

import com.example.demo.persistance.model.movie.personal.Profession;

import java.io.Serializable;
import java.util.Objects;

public class ActorRequestModel implements Serializable {
    private static final long serialVersionUID = -3768119967599234152L;
    private String name;
    private String surname;
    private int age;
    private Profession profession;

    public ActorRequestModel(String name, String surname, int age, Profession profession) {
        this.name = name;
        this.surname = surname;
        if (age > 0 && age <= 100){
            this.age = age;
        } else {
            throw new RuntimeException("Actor age is not valid");
        }
        if(profession.equals(Profession.actor)){
            this.profession = profession;
        } else {
            throw new RuntimeException("Profession is not valid");
        }
    }

    public ActorRequestModel() {
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
        if (age > 0 && age <= 100){
            this.age = age;
        } else {
            throw new RuntimeException("Actor age is not valid");
        }
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        if(profession.equals(Profession.actor)){
            this.profession = profession;
        } else {
            throw new RuntimeException("Profession is not valid");
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorRequestModel that = (ActorRequestModel) o;
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
        return "ActorRequestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}
