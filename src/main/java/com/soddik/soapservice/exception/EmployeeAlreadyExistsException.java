package com.soddik.soapservice.exception;

import java.io.Serial;

public class EmployeeAlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5535110400093068452L;

    private final String message;

    public EmployeeAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
