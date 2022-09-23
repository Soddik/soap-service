package com.soddik.soapservice.validator;

import com.soddik.soapservice.entity.Employee;

import java.util.function.Function;

import static com.soddik.soapservice.validator.EmployeeValidator.*;
import static com.soddik.soapservice.validator.EmployeeValidator.ValidationResult.*;

public interface EmployeeValidator extends Function<Employee, ValidationResult> {
    String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-zA-Z]).{3,}$";

    static EmployeeValidator isNameValid() {
        return employee -> employee.getName().isEmpty() ? INVALID_NAME : SUCCESS;
    }

    static EmployeeValidator isLoginValid() {
        return employee -> employee.getLogin().isEmpty() ? INVALID_LOGIN : SUCCESS;
    }

    static EmployeeValidator isPasswordValid() {
        return employee -> employee.getPassword().matches(PASSWORD_PATTERN) ? SUCCESS : INVALID_PASSWORD;
    }

    default EmployeeValidator and(EmployeeValidator otherValidation) {
        return employee -> {
            ValidationResult result = this.apply(employee);
            return result.equals(SUCCESS) ? otherValidation.apply(employee) : result;
        };
    }

    enum ValidationResult {
        SUCCESS("success"),
        INVALID_NAME("Empty \"name\" attribute."),
        INVALID_LOGIN("Empty \"login\" attribute."),
        INVALID_PASSWORD("Password must contain at least 1: capital letter and number.");

        private final String value;

        ValidationResult(String value) {
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }
}
