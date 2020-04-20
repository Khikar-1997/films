package com.example.demo.exception;

public class ComposerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1703109607337073582L;

    public ComposerNotFoundException(String massage) {
        super(massage);
    }
}
