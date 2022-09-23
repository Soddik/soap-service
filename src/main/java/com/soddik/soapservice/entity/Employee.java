package com.soddik.soapservice.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "employee")
public final class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "employee_login", nullable = false, unique = true)
    private String login;
    private String name;
    private String password;

    @ManyToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = EAGER)
    @JoinTable(
            name = "employee_role",
            joinColumns = {@JoinColumn(name = "employee_login")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<EmployeeRole> employeeRoles = new HashSet<>();

    public Set<EmployeeRole> getEmployeeRoles() {
        return employeeRoles;
    }

    public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
        this.employeeRoles = employeeRoles;
    }

    public Employee() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addRole(EmployeeRole employeeRole) {
        employeeRoles.add(employeeRole);
    }

    public Set<EmployeeRole> getRoles() {
        return new HashSet<>(employeeRoles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getLogin(), employee.getLogin()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getPassword(), employee.getPassword()) && Objects.equals(employeeRoles, employee.employeeRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getName(), getPassword(), employeeRoles);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + employeeRoles +
                '}';
    }
}
