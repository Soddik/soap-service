package com.soddik.soapservice.repository;

import com.soddik.soapservice.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<EmployeeRole, Long> {
}
