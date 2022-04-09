package com.samoylov.client.exception;

import com.samoylov.client.exception.utility.ServerExceptionParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> globalExceptionHandling(HttpClientErrorException exception) {
        return new ResponseEntity<>(
                ServerExceptionParser.removeDetails(exception.getResponseBodyAsString()),
                exception.getStatusCode());
    }
}