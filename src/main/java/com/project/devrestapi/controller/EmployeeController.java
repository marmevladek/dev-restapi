package com.project.devrestapi.controller;

import com.project.devrestapi.model.Employee;
import com.project.devrestapi.request.EmployeeRequest;
import com.project.devrestapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeRequest), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
