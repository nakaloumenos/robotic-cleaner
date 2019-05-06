package com.example.roboticcleaner.api;

import com.example.roboticcleaner.exception.ErrorResponse;
import com.example.roboticcleaner.exception.OutOfBoundsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CleanUpExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OutOfBoundsException.class)
    public ResponseEntity handleOutOfBounsException(OutOfBoundsException exception) {
        String errorMessage = exception.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        log.debug("Returning 400 Bad Request");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "Input of X and Y coordinates must be a List of exactly 2 Integers and areaSize and startingPosition must be Not Null";
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        log.debug("Returning 400 Bad Request");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
