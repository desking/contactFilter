package com.kvashenko.contact_filter.controller;

import com.kvashenko.contact_filter.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Error> exception(Throwable exception) {
        Error error = new Error(HttpStatus.NOT_FOUND, exception);
        return new ResponseEntity<>(error, error.getStatus());
    }
}