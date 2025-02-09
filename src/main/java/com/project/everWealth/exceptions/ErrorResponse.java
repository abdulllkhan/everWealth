package com.project.everWealth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor
// @NoArgsConstructor
@Data
public class ErrorResponse {
    private final String errorCode;
    private final String errorMessage;

    // Default constructor
    public ErrorResponse() {
        this.errorCode = "";
        this.errorMessage = "";
    }

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    // Getters for errorCode and errorMessage
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}