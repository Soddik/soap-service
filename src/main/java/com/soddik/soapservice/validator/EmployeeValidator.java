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
        SUCCESS,
        INVALID_NAME,
        INVALID_LOGIN,
        INVALID_PASSWORD
    }
}
