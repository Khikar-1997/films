package com.example.demo.exception;

public class MovieNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -644839384761147100L;

    public MovieNotFoundException(String massage) {
        super(massage);
    }
}
