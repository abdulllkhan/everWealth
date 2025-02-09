package com.project.everWealth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Resource not found")
@ResponseBody
public class CustomException2 extends RuntimeException {
    private final HttpStatus httpStatus;

    public CustomException2(HttpStatus httpStatus, String message) {
        super(message, null);
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return "Custom error message: " + super.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    
}
