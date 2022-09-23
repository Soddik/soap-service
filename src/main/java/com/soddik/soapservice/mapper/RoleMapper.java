package com.soddik.soapservice.mapper;

import com.soddik.soapservice.dto.RoleDto;
import com.soddik.soapservice.entity.EmployeeRole;

public class RoleMapper {
    public static RoleDto toDto(EmployeeRole role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }

    public static EmployeeRole toEntity(RoleDto dto){
        EmployeeRole role = new EmployeeRole();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
