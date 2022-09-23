package com.soddik.soapservice.repository;

import com.soddik.soapservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Transactional
    Employee getEmployeeByLogin(String login);
}
