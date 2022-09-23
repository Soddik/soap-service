package com.soddik.soapservice.exception;

import java.io.Serial;

public class EmployeeValidationException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 5535110400093068459L;

    private final String message;

    public EmployeeValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
