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
            admin.setName("Админ");

            EmployeeRole operator = new EmployeeRole();
            operator.setName("Оператор");

            EmployeeRole analit = new EmployeeRole();
            analit.setName("Аналитик");

            roleService.addRole(admin);
            roleService.addRole(operator);
            roleService.addRole(analit);
        };
    }
}
