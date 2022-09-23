package com.soddik.soapservice.mapper;

import com.soddik.soapservice.dto.*;

import com.soddik.soapservice.entity.Employee;

import java.util.List;

public class EmployeeMapper {
    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setLogin(employee.getLogin());
        dto.setPassword(employee.getPassword());
        dto.getRoles().addAll(employee.getRoles().stream()
                .map(RoleMapper::toDto)
                .toList());
        return dto;
    }

    public static SimpleEmployeeDto toSimpleEmployeeDto(Employee employee) {
        SimpleEmployeeDto dto = new SimpleEmployeeDto();
        dto.setName(employee.getName());
        dto.setLogin(employee.getLogin());
        dto.setPassword(employee.getPassword());
        return dto;
    }

    public static Employee toEntity(AddEmployeeRequest request) {
        return toEntity(request.getName(), request.getLogin(), request.getPassword(), request.getRole());
    }

    public static Employee toEntity(UpdateEmployeeRequest request) {
        return toEntity(request.getName(), request.getLogin(), request.getPassword(), request.getRole());
    }

    private static Employee toEntity(String name, String login, String password, List<RoleDto> roles) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setLogin(login);
        employee.setPassword(password);
        roles.stream()
                .map(RoleMapper::toEntity)
                .toList()
                .forEach(employee::addRole);
        return employee;
    }
}
