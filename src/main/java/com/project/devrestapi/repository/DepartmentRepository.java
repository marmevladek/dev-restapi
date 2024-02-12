package com.project.devrestapi.repository;

import com.project.devrestapi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, PagingAndSortingRepository<Department, Long> {
    Department findByName(String name);
}
