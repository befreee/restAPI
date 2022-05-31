package org.example;


import org.example.dao.EmployeeDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.example"})
public class RestfullApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfullApplication.class, args);
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        employeeDAO.getEmployee("E01");
//        employeeDAO.getAllEmployees();
    }
}
