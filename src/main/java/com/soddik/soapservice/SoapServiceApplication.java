package com.soddik.soapservice;

import com.soddik.soapservice.entity.EmployeeRole;
import com.soddik.soapservice.service.EmployeeRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner rolesDemo(EmployeeRoleService roleService) {
        return args -> {
            EmployeeRole admin = new EmployeeRole();
            admin.setName("Admin");

            EmployeeRole operator = new EmployeeRole();
            operator.setName("Operator");

            EmployeeRole analyst = new EmployeeRole();
            analyst.setName("Analyst");

            roleService.addRole(admin);
            roleService.addRole(operator);
            roleService.addRole(analyst);
        };
    }
}
