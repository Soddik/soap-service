package com.soddik.soapservice.service;

import com.soddik.soapservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByLogin(String login);

    List<Employee> getAllEmployees();

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(String login);
}
