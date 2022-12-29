package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @ApiOperation(value = "Create Employee", response = Employee.class, tags = "Employee")
    @PostMapping(value = "/createEmployee/{email, password, hourlyPayRate, position}")
    public Employee createEmployee(String email, String password, BigDecimal hourlyPayRate, int position) {
        employees.add(new Employee(employees.get(employees.size() - 1).getEmployeeId() + 1, email, password,
                hourlyPayRate, position));
        return employees.get(employees.size() - 1);
    }

    @ApiOperation(value = "Get list of Employees", response = Iterable.class, tags = "Employee")
    @GetMapping(value = "/getEmployees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @ApiOperation(value = "Get Employee by Id", response = Employee.class, tags = "Employee")
    @GetMapping(value = "/getEmployeeById/{employeeId}")
    public Employee getEmployeeById(@PathVariable(value = "employeeId") int employeeId) {
        return employees.stream().filter(x -> x.getEmployeeId() == (employeeId)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get Employee by Email", response = Employee.class, tags = "Employee")
    @GetMapping(value = "/getEmployeeByEmail/{email}")
    public Employee getEmployeeByEmail(@PathVariable(value = "email") String email) {
        return employees.stream().filter(x -> x.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Change Employee information", response = Employee.class, tags = "Employee")
    @PutMapping(value = "/changeEmployee{employeeId, email, password, hourlyPayRate, position}}")
    public ResponseEntity<?> changeEmployeeInformation(int employeeId, String email, String password,
            BigDecimal hourlyPayRate, int position) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployeeId() == employeeId) {
                employees.set(i, new Employee(employee.getEmployeeId(), email, password,
                        hourlyPayRate, position));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Delete Employee by Id", response = Employee.class, tags = "Employee")
    @DeleteMapping(value = "/deleteEmployeeById/{employeeId}")
    public ResponseEntity<?> deleteEmployee(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == (employeeId)) {
                employees.remove(i);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
