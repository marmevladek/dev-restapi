package com.project.devrestapi.service;

import com.project.devrestapi.model.Employee;
import com.project.devrestapi.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(EmployeeRequest employeeRequest);

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);


}
