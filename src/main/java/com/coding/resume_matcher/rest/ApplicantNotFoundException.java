package com.coding.resume_matcher.rest;

public class ApplicantNotFoundException extends RuntimeException{

    public ApplicantNotFoundException(String message) {
        super(message);
    }

    public ApplicantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicantNotFoundException(Throwable cause) {
        super(cause);
    }
}
