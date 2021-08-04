package com.intetics.touristbook.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException() {}

    public LocationNotFoundException(String message) {
        super(message);
    }
}
