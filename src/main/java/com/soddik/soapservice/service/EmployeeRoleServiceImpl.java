package com.soddik.soapservice.service;

import com.soddik.soapservice.entity.EmployeeRole;
import com.soddik.soapservice.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    private final RoleRepository roleRepository;

    public EmployeeRoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public EmployeeRole findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public void addRole(EmployeeRole role) {
        roleRepository.save(role);
    }

    @Override
    public void removeRole(Long id) {
        roleRepository.deleteById(id);
    }
}
