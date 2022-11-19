package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Employee;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeController {
    List<Employee> employees = new ArrayList<Employee>();
    {
        employees.add(new Employee(1, "employee1@gmail.com", "Password123", BigDecimal.valueOf(20), 1));
        employees.add(new Employee(2, "employee2@gmail.com", "Password123", BigDecimal.valueOf(8), 2));
        employees.add(new Employee(3, "employee3@gmail.com", "Password123", BigDecimal.valueOf(15), 3));
        employees.add(new Employee(4, "employee4@gmail.com", "Password123", BigDecimal.valueOf(15), 3));
    }

    @ApiOperation(value = "Get list of Employees in the System ", response = Iterable.class, tags = "getEmployees")
    @RequestMapping(value = "/getEmployees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @ApiOperation(value = "Get specific Employee in the System ", response = Employee.class, tags = "getEmployeeById")
    @RequestMapping(value = "/getEmployeeById/{employeeId}")
    public Employee getEmployeeById(@PathVariable(value = "employeeId") int employeeId) {
        return employees.stream().filter(x -> x.getEmployeeId() == (employeeId)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Employee in the System ", response = Employee.class, tags = "getEmployeeByEmail")
    @RequestMapping(value = "/getEmployeeByEmail/{email}")
    public Employee getEmployeeByEmail(@PathVariable(value = "email") String email) {
        return employees.stream().filter(x -> x.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList()).get(0);
    }
}
