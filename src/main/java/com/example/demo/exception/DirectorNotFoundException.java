package com.example.demo.exception;

public class DirectorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5480185516749711020L;

    public DirectorNotFoundException(String massage) {
        super(massage);
    }
}
