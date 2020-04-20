package com.example.demo.exception;

public class SoundtrackNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7204314574984892033L;

    public SoundtrackNotFoundException(String massage) {
        super(massage);
    }
}
