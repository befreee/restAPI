package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
public class MainRESTController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to REST template";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Employee> getAllEmploy() {
        System.out.println("getting all employees: ");
        return employeeDAO.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{empNo}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        System.out.println("getting one employ");
        Employee employee = employeeDAO.getEmployee(empNo);
        return employee;
    }


    @RequestMapping(value = "/employee", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println("Here we adding new employee: " + employee.getEmpName());
        return employeeDAO.addEmployee(employee);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee update(@RequestBody Employee employee) {
        System.out.println("Here we editing employee: " + employee.getEmpName());
        return employeeDAO.updateEmployee(employee);
    }

    @RequestMapping(value = "/employee/{empNo}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("empNo") String empNo) {
        System.out.println("Here we deleting employee: " + empNo);
        employeeDAO.deleteEmployee(empNo);
    }
}
