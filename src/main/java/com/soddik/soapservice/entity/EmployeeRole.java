package com.soddik.soapservice.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "roles")
public final class EmployeeRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "employeeRoles")
    private Set<Employee> employees = new HashSet<>();

    public EmployeeRole() {
    }

    public EmployeeRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRole employeeRole)) return false;
        return Objects.equals(getId(), employeeRole.getId()) && Objects.equals(getName(), employeeRole.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
