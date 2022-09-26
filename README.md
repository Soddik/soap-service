![opensource](https://camo.githubusercontent.com/97d4586afa582b2dcec2fa8ed7c84d02977a21c2dd1578ade6d48ed82296eb10/68747470733a2f2f6261646765732e66726170736f66742e636f6d2f6f732f76312f6f70656e2d736f757263652e7376673f763d313033)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg)
# soap-service
Simple employee(with role) CRUD soap service
## Prerequisites
- JDK 17
- PostgreSQL
- SoapUI/Postman
## Getting started
1. Clone project: `https://github.com/Soddik/soap-service.git`
2. Install PostgreSQL 
3. Created PostgreSQL DB `employee_db` (all tables are generated automatically with Spring Data JPA)
4. Build with `mvn clean install` from root project folder via CLI
5. Run `mvn spring-boot:run` from root project folder via CLI
## Developing
### Build with
- Java 17
- Spring Boot
- Spring Data JPA
- WSDL
- PostgreSQL
### Usage
Use endpoint `http://localhost:8080/ws/employees.wsdl`

Available employee roles:
- Admin
- Operator
- Analyst

Employee password requirements: 
- must contain at least 1: capital letter and number
