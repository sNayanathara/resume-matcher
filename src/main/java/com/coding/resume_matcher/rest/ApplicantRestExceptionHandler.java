package com.coding.resume_matcher.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicantRestExceptionHandler {

    //exception handler for catching NOT_FOUND exception
    @ExceptionHandler
    public ResponseEntity<ApplicantErrorResponse> handleException(ApplicantNotFoundException exec){

        ApplicantErrorResponse error = new ApplicantErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exec.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //exception handler for catching any other exceptions - catch all
    @ExceptionHandler
    public ResponseEntity<ApplicantErrorResponse> handleException(Exception exec){

        ApplicantErrorResponse error = new ApplicantErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exec.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
