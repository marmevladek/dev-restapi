package com.project.devrestapi.service;

import com.project.devrestapi.model.Department;
import com.project.devrestapi.repository.DepartmentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
        return departmentRepository.findAll(pages).getContent();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getSingleDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) return department.get();
        throw new RuntimeException("Department is not found for the id " + id);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }



}
