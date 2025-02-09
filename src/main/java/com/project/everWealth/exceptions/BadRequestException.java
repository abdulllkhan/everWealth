package com.project.everWealth.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public class BadRequestException extends RuntimeException {

    private final int errorCode;

    public BadRequestException(int errorCode, String message) {
        ResponseBody responseBody = getClass().getAnnotation(ResponseBody.class);
        ResponseStatus responseStatus = getClass().getAnnotation(ResponseStatus.class);
        Map<String, Object> response = new HashMap<>();
        response.put("status", responseStatus.value());
        response.put("error", responseStatus.reason());
        response.put("message", message);
        response.put("errorCode", errorCode);
        this.errorCode = errorCode;
    }

    //     super(message, null);
    //     this.errorCode = errorCode;
    // }

    

    public int getErrorCode() {
        return errorCode;
    }
    
}