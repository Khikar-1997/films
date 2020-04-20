package com.example.demo.rest.model.user;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRequestModel implements Serializable {
    private static final long serialVersionUID = 970116342157696162L;
    private String name;
    private String surname;
    private String phoneNumber;
    private int age;
    private String username;
    private String password;

    public UserRequestModel(String name, String surname, String phoneNumber, int age, String username, String password) {
        this.name = name;
        this.surname = surname;
        if (phoneNumber.length() > 0 && phoneNumber.length() <= 12) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new RuntimeException("Phone number is not valid");
        }
        if (age > 0 && age <= 100){
            this.age = age;
        } else {
            throw new RuntimeException("User age is not valid");
        }
        this.username = username;
        if (isPasswordValid(password)) {
            this.password = password;
        } else {
            throw new RuntimeException("Password is not valid");
        }
    }

    public UserRequestModel() {
    }

    public String bCryptPassword() {
        return BCrypt.hashpw(getPassword(), BCrypt.gensalt());
    }

    public boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile("((?=.*\\d{3,})(?=.*[A-Z])(?=.*[#%!]).{8,40})");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 0 && phoneNumber.length() <= 12) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new RuntimeException("Phone number is not valid");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 100){
            this.age = age;
        } else {
            throw new RuntimeException("User age is not valid");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
        } else {
            throw new RuntimeException("Password is not valid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequestModel that = (UserRequestModel) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber, age, username, password);
    }

    @Override
    public String toString() {
        return "UserRequestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
