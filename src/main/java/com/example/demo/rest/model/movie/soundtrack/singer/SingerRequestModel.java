package com.example.demo.rest.model.movie.soundtrack.singer;

import java.io.Serializable;
import java.util.Objects;

public class SingerRequestModel implements Serializable {
    private static final long serialVersionUID = 8005064867345712737L;
    private String name;
    private String surname;

    public SingerRequestModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public SingerRequestModel() {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerRequestModel that = (SingerRequestModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "SingerRequestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
