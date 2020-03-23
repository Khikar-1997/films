package com.example.demo.exception;

public class TrailerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -9209279098426549544L;

    public TrailerNotFoundException(String massage) {
        super(massage);
    }
}
