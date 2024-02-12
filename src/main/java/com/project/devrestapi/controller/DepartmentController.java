package com.project.devrestapi.controller;

import com.project.devrestapi.model.Department;
import com.project.devrestapi.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getDepartments(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(departmentService.getDepartments(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getSingleDepartment(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.getSingleDepartment(id), HttpStatus.OK);
    }

    @DeleteMapping("/departments")
    public ResponseEntity<HttpStatus> deleteDepartment(@RequestParam Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
    }

}
