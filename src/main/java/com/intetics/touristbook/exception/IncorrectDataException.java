package com.intetics.touristbook.exception;

public class IncorrectDataException extends RuntimeException {

    public IncorrectDataException() {}

    public IncorrectDataException(String message) {
        super(message);
    }
}
