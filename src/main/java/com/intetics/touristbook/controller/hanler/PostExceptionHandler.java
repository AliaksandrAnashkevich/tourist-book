package com.intetics.touristbook.controller.hanler;

import com.intetics.touristbook.exception.IncorrectDataException;
import com.intetics.touristbook.exception.LocationNotFoundException;
import com.intetics.touristbook.exception.PostNotFoundException;
import com.intetics.touristbook.exception.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class PostExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionDto postNotFound(RuntimeException e) {
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionDto locationNotFound(RuntimeException e) {
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(IncorrectDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionDto incorrectData(RuntimeException e) {
        return new ExceptionDto(e.getMessage());
    }
}
