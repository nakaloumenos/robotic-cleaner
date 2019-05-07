package com.example.roboticcleaner.api;

import com.example.roboticcleaner.exception.OutOfBoundsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CleanUpExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.debug(e.getMessage(), e);
        return "Invalid input!";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OutOfBoundsException.class)
    public String handleOutOfBounsException(final OutOfBoundsException e) {
        log.debug(e.getMessage(), e);
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String handleUnexpectedRuntimeException(final RuntimeException e) {
        log.error("Unexpected exception", e);
        return "An unexpected error occurred!";
    }

}
