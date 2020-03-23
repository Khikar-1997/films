package com.example.demo.exception;

public class ActorNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5488531597994819460L;

    public ActorNotFoundException(String massage) {
        super(massage);
    }
}
