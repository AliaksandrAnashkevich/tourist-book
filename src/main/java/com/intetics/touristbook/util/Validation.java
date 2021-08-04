package com.intetics.touristbook.util;

import com.intetics.touristbook.exception.IncorrectDataException;
import com.intetics.touristbook.service.dto.PostDto;

public class Validation {

    private static volatile Validation instance;

    private final static String isWorld = "^[A-Za-z]+$";

    public static Validation getInstance() {
        Validation localInstance = instance;
        if (localInstance == null) {
            synchronized (Validation.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Validation();
                }
            }
        }
        return localInstance;
    }

    public void validation(PostDto post) {
        if (post.getLocation() == null
                || !post.getLocation().matches(isWorld)
                || post.getUsername() == null
                || !post.getUsername().matches(isWorld)
        ) {
            throw new IncorrectDataException(ConstantExceptionMessage.incorrectData);
        }
    }
}
