package com.example.roboticcleaner.exception;

public class ErrorResponse {

    private String errorMessage;

    public ErrorResponse(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
