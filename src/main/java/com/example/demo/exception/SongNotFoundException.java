package com.example.demo.exception;

public class SongNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 8402427484897335696L;

    public SongNotFoundException(String massage) {
        super(massage);
    }
}
