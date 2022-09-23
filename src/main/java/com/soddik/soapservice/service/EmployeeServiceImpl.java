package com.soddik.soapservice.service;

import com.soddik.soapservice.entity.Employee;
import com.soddik.soapservice.exception.EmployeeAlreadyExistsException;
import com.soddik.soapservice.exception.EmployeeNotFoundException;
import com.soddik.soapservice.exception.EmployeeValidationException;
import com.soddik.soapservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.soddik.soapservice.validator.EmployeeValidator.*;
import static com.soddik.soapservice.validator.EmployeeValidator.ValidationResult.SUCCESS;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeByLogin(String login) {
        return employeeRepository.getEmployeeByLogin(login);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getLogin())) {
            throw new EmployeeAlreadyExistsException(String.format("Employee with login:\"%s\" already exists!", employee.getLogin()));
        }

        ValidationResult validationResult = isNameValid()
                .and(isLoginValid())
                .and(isPasswordValid())
                .apply(employee);

        if (validationResult.equals(SUCCESS)) {
            employeeRepository.save(employee);
            return true;
        } else {
            throw new EmployeeValidationException("Validation failed, cause: " + validationResult.getValue());
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getLogin())) {
            throw new EmployeeNotFoundException(String.format("Employee with login: \"%s\" not found!", employee.getLogin()));
        }

        ValidationResult validationResult = isNameValid()
                .and(isLoginValid())
                .and(isPasswordValid())
                .apply(employee);

        if (validationResult.equals(SUCCESS)) {
            employeeRepository.save(employee);
            return true;
        } else {
            throw new EmployeeValidationException("Validation failed, cause: " + validationResult.getValue());
        }
    }

    @Override
    public boolean deleteEmployee(String login) {
        if (!employeeRepository.existsById(login)) {
            throw new EmployeeNotFoundException(String.format("Employee with login: \"%s\" not found!", login));
        }

        employeeRepository.deleteById(login);
        return !employeeRepository.existsById(login);

    }
}
