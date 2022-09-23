package com.soddik.soapservice.service;

import com.soddik.soapservice.entity.EmployeeRole;

public interface EmployeeRoleService{
    EmployeeRole findById(Long id);
    void addRole(EmployeeRole role);
    void removeRole(Long id);
}
