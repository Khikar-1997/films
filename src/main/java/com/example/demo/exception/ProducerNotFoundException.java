package com.example.demo.exception;

public class ProducerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5806441233907022282L;

    public ProducerNotFoundException(String massage) {
        super(massage);
    }
}
