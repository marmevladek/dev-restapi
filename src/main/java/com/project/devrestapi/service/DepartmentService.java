package com.project.devrestapi.service;

import com.project.devrestapi.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments(int pageNumber, int pageSize);

    Department saveDepartment(Department department);

    Department getSingleDepartment(Long id);

    void deleteDepartment(Long id);

    Department updateDepartment(Department department);

}
