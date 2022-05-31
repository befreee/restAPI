package org.example.dao;


import org.example.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAO {

    private static final Map<String, Employee> empMap = new HashMap<>();

    static {
        initEmployee();
    }

    private static void initEmployee() {
        Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Williams", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Boss");
        Employee emp4 = new Employee("E04", "MacDonald", "Manager");
        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
        empMap.put(emp4.getEmpNo(), emp4);
    }

    public Employee getEmployee(String empNo) {
        System.out.println("getEmployees: ");
        return empMap.get(empNo);
    }

    public Employee addEmployee(Employee employee) {
        System.out.println("Adding employee: " + employee);
        empMap.put(employee.getEmpNo(), employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        empMap.put(employee.getEmpNo(), employee);
        return employee;
    }

    public void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(empMap.values());
    }
}
