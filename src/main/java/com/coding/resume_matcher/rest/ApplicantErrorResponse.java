package com.coding.resume_matcher.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ApplicantErrorResponse {

    private int status;
    private String message;
    private long timestamp;

    public ApplicantErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
