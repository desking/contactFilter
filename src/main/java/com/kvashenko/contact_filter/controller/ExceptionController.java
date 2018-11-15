package com.kvashenko.contact_filter.controller;

import com.kvashenko.contact_filter.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.PatternSyntaxException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = PatternSyntaxException.class)
    public ResponseEntity<Error> patternException(PatternSyntaxException exception) {
        Error error = new Error(HttpStatus.BAD_REQUEST, "Invalid regular expression " + exception.getPattern(), exception);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Error> exception(Throwable exception) {
        Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, exception);
        return new ResponseEntity<>(error, error.getStatus());
    }
}
