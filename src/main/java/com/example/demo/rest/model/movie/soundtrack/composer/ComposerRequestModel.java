package com.example.demo.rest.model.movie.soundtrack.composer;

import java.io.Serializable;
import java.util.Objects;

public class ComposerRequestModel implements Serializable {
    private static final long serialVersionUID = 2481539064421453004L;
    private String name;
    private String surname;

    public ComposerRequestModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public ComposerRequestModel() {
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
        ComposerRequestModel that = (ComposerRequestModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "ComposerRequestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
