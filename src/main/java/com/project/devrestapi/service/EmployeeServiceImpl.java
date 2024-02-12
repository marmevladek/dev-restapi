package com.project.devrestapi.service;

import com.project.devrestapi.model.Employee;
import com.project.devrestapi.model.Wage;
import com.project.devrestapi.repository.EmployeeRepository;
import com.project.devrestapi.repository.WageRepository;
import com.project.devrestapi.request.EmployeeRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final DepartmentService departmentService;
    private final EmployeeRepository employeeRepository;
    private final WageRepository wageRepository;

    public EmployeeServiceImpl(DepartmentService departmentService,
                               EmployeeRepository employeeRepository,
                               WageRepository wageRepository) {
        this.departmentService = departmentService;
        this.employeeRepository = employeeRepository;
        this.wageRepository = wageRepository;
    }

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(EmployeeRequest employeeRequest) {
        Wage wage = new Wage();
        wage.setSizeWage(employeeRequest.getWage());
        wageRepository.save(wage);

        Employee employee = new Employee(employeeRequest);
        employee.setWage(wage);
        employee.setDepartment(departmentService.getSingleDepartment(employeeRequest.getDepartmentId()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) return employee.get();
        throw new RuntimeException("Employee is not found for the id " + id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }



}
