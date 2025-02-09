package com.project.everWealth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    public Long errorCode;
    
    public String errorMessage;
    
}
