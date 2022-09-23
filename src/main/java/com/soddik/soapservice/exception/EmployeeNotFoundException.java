package com.soddik.soapservice.exception;

import java.io.Serial;

public class EmployeeNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5535110400093068444L;

    private final String message;

    public EmployeeNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
