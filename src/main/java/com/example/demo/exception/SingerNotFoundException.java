package com.example.demo.exception;

public class SingerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7067899390355658874L;

    public SingerNotFoundException(String massage) {
        super(massage);
    }
}
